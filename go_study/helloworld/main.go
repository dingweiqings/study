package main

import "fmt"
func main() {
 Example()
	

}
type Persoon struct{
	age int
	name string
}
func Example() {
	// m := gomail.NewMessage()
	// m.SetHeader("From", "alert@fastonetech.com")
	// m.SetHeader("To", "weiqing.ding@fastonetech")
	// // m.SetAddressHeader("Cc", "dan@example.com", "Dan")
	// m.SetHeader("Subject", "Hello!")
	// m.SetBody("text/html", "Hello <b>Bob</b> and <i>Cora</i>!")
	// // m.Attach("/home/Alex/lolcat.jpg")

	// d := gomail.NewDialer("smtp.mxhichina.com", 465, "alert@fastonetech.com", "fnsU9XYqRV8A")

	// // Send the email to Bob, Cora and Dan.
	// if err := d.DialAndSend(m); err != nil {
	// 	panic(err)
	// }
	// layout := "2023-08-18 15:04:05.999999"
    // t, _ := time.Parse(layout, "0001-01-01 00:00:00")
	// fmt.Println(t.IsZero())

	a:=&Persoon{10,"ddd"}
	b:=(*a);
	b.age=100
	b.name="eee"
	fmt.Println(a)
	fmt.Println(b)

}