//go:generate goyacc -o expr.go -p "expr" expr.y

// Expr is a simple expression evaluator that serves as a working example of
// how to use Go's yacc implementation.
package main

import (
	"bufio"
	"io"
	"log"
	"math/big"
	"os"
)

func main() {
	in := bufio.NewReader(os.Stdin)
	a := big.Float{}
	a.String()
	for {
		if _, err := os.Stdout.WriteString("> "); err != nil {
			log.Println("WriteString: ", err)
		}
		line, err := in.ReadBytes('\n')
		if err == io.EOF {
			return
		}
		if err != nil {
			log.Fatalf("ReadBytes: %s", err)
		}
		exprParse(newExprLex(line))
	}
}
