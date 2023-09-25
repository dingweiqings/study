# 安装
go install golang.org/x/tools/cmd/goyacc@latest

# goyacc使用
 Usage of goyacc:
  -l    disable line directives
  -o string
        parser output (default "y.go")
  -p string
        name prefix to use in generated code (default "yy")
  -v string
        create parsing tables (default "y.output")
会根据你的语法规则(.y后缀的)生成.go文件.  -o指定文件的名称 -p 指定生成parse函数前缀,默认是叫yyParse,以供外部调用
goyacc -o expr.go -p expr expr.y
# 构建
go build expr.go lexer.go main.go 