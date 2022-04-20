package main

import "fmt"

func main() {
	// url := "http://161.189.180.105:9000/api/v1/apps/3"
	// fmt.Println("URL:>", url)
	// //json序列化
	// patch := "{\n" +
	// 	"   \n" +
	// 	"    \"name\":\"raw-command\",\n" +
	// 	"    \"cloudImage\":\"fs-compute\",\n" +
	// 	"    \"description\":\"fastone test raw-command update\",\n" +
	// 	"definition" + ":" + "aaa"
	// "}\n"
	// fmt.Println(url, "patch", patch)

	// var jsonStr = []byte(patch)
	// fmt.Println("jsonStr", jsonStr)
	// fmt.Println("new_str", bytes.NewBuffer(jsonStr))

	// req, err := http.NewRequest("PATCH", url, bytes.NewBuffer(jsonStr))
	// // req.Header.Set("X-Custom-Header", "myvalue")
	// req.Header.Set("Content-Type", "application/json")
	// req.Header.Set("Authorization", "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1Iiwicm9sZXMiOlsiUk9MRV9BRE1JTiJdLCJuYW1lIjoiYWRtaW4iLCJ1c2VyVHlwZSI6IkxPQ0FMIiwiZXhwIjoxNjM0OTE1NTYzLCJpYXQiOjE2MzQ4NzIzNjMsInVzZXJuYW1lIjoiYWRtaW4ifQ.jvqtwYMA3_eq91GNrWIzKti9jEkJgJO58XixjxVq6NqAAQbffuzcnm1wWKmfoyc1uoHt4IgLXWcKdcQj9wQAEw")

	// client := &http.Client{}
	// resp, err := client.Do(req)
	// if err != nil {
	// 	panic(err)
	// }
	// defer resp.Body.Close()

	// fmt.Println("response Status:", resp.Status)
	// fmt.Println("response Headers:", resp.Header)
	// body, _ := ioutil.ReadAll(resp.Body)
	// fmt.Println("response Body:", string(body))
	// var b bool = true
	// fmt.Println("outer init ", b)
	// if b {
	// 	b := falseqw
	// 	fmt.Println("inside ", b)
	// }
	// fmt.Printf("outer %+v", b)
	str := "refs/heads/topic/kurt.ding/consul"
	fmt.Println(str[11:])
}
