package main

import (
	"fmt"
	"os"
	"text/template"
)

type Msg struct {
	Alerts  AlertBody
	Message string
}

type AlertBody struct {
	Firing   []Alert
	Resolved []Alert
}

type Alert struct {
	Annotations map[string]interface{}
	Labels      map[string]interface{}
	SortedPairs []string
	Status      string
}

// {{if eq  .Name  \"1.000\" }}{{len .Name}} 正常a {{else}} 异常111111b{{ .Name   }}{{end}}
func main() {
	var error error = nil
	var tpl *template.Template
	t := template.New("foo").Funcs(make(template.FuncMap))
	tpl, error = t.Parse(`
	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name="viewport" content="width=device-width" />
</head>
<body>
<style>
  table{
    border-collapse: collapse;
  }
  tr, td {
    border-collapse: collapse;
    border: 1px solid rgb(158, 151, 151);
  }

  td {
    min-width: 100px;
  }

</style>
{{ define "alert" }}
  {{ if gt (len .Annotations.SortedPairs) 0 }}
<tr >
<td>{{if eq .Annotations.resourceName "master" }} 系统平台 {{else}} {{ .Annotations.resourceName }}{{end}} </td><td>{{if eq .Annotations.resourceName "master" }} {{ .Annotations.mgmtNode }}{{ else }}{{ .Annotations.resourceNode }}{{end}}</td>
  <td> {{if eq .Labels.metricName "NODE_RUNNING_STATUS"}} {{if eq  .Annotations.curValue  "1.000" }} 正常{{else}} 异常{{end}} {{else}} {{ .Annotations.curValue }} {{end}} 	  </td>
  <td>{{ .Annotations.monitorMetricStr }}</td><td>{{ if eq .Status "firing" }}告警{{ end }}{{ if eq .Status "resolved" }}恢复{{ end }}</td><td > {{ .Annotations.level }}</td>
</tr>
{{ end }}
{{ end }}
{{ if .Message  }}
    <p>This is an alert test msg from FASTONE product.</p>
{{else}}
    {{ if gt (len .Alerts.Firing) 0 }}
    <p>  您的 {{ ( index .Alerts.Firing 0 ).Annotations.resourceType }} 发生告警，具体如下：</p>
    <table >
      {{ if gt (len .Alerts.Firing) 0 }}
        <tr >
          <td>对象</td><td>节点</td><td>监控项当前值</td><td>告警规则</td><td>当前状态</td><td>级别</td>
        </tr>
        {{ range .Alerts.Firing }}
          {{ template "alert" . }}
        {{ end }}
      {{ end }}
      </table>		
      <p>以上问题请及时处理，谢谢！</p>
    {{ end }}


    {{ if gt (len .Alerts.Resolved) 0 }}
      您的{{ ( index .Alerts.Resolved  0).Annotations.resourceType }}告警已恢复，具体如下：
      <table >

        {{ if gt (len .Alerts.Resolved) 0 }}
        <tr >
          <td>对象</td><td>节点</td><td>监控项当前值</td><td>告警规则</td><td>当前状态</td><td>级别</td>
        </tr>
          {{ range .Alerts.Resolved }}
            {{ template "alert" . }}
          {{ end }}
        {{ end }}
        </table>		
    {{ end }}
{{end }}


	
</body>
</html>

	`)
	// tpl, error = t.Parse(`=={{ .Age | printf "%.3f" }}== `)

	// tpl, error = t.ParseFiles("a.tpl")
	if error != nil {
		panic(error)
	}
	var annotationsMap = make(map[string]interface{})

	/* map插入key - value对,各个国家对应的首都 */
	annotationsMap["resourceNode"] = "巴黎"
	annotationsMap["metricName"] = "罗马"
	annotationsMap["curValue"] = "东京"
	annotationsMap["monitorMetricStr "] = "新德里"
	annotationsMap["level"] = "告警"
	
	var labelsMap = make(map[string]interface{})

	/* map插入key - value对,各个国家对应的首都 */
	labelsMap["resourceNode"] = "巴黎"
	labelsMap["metricName"] = "罗马"
	labelsMap["curValue"] = "东京"
	labelsMap["monitorMetricStr "] = "新德里"
	labelsMap["level"] = "告警"

	var firingAlert []Alert = make([]Alert, 10)
	var sortedPairs []string = make([]string, 10)
	for k, _ := range annotationsMap {
		sortedPairs = append(sortedPairs, k)
	}
	annotationsMap["SortedPairs"] = sortedPairs
	for i := 0; i < 10; i++ {
		var alerts Alert = Alert{
			Annotations: annotationsMap,
			Labels:      labelsMap,
			Status:      "Firing",
		}
		firingAlert = append(firingAlert, alerts)

	}

	var alertBody AlertBody = AlertBody{
		Firing:   firingAlert,
		Resolved: make([]Alert, 0),
	}
	ctx := &Msg{
		Alerts:  alertBody,
		Message: "",
	}
	error = tpl.Execute(os.Stderr, ctx)
	if error != nil {
		fmt.Printf("Error %s", error)
		return
	}

}
