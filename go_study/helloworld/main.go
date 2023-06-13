package main

import (
	gomail "gopkg.in/gomail.v2"
)
func main() {
 Example()
	

}
func Example() {
	m := gomail.NewMessage()
	m.SetHeader("From", "alert@fastonetech.com")
	m.SetHeader("To", "weiqing.ding@fastonetech")
	// m.SetAddressHeader("Cc", "dan@example.com", "Dan")
	m.SetHeader("Subject", "Hello!")
	m.SetBody("text/html", "Hello <b>Bob</b> and <i>Cora</i>!")
	// m.Attach("/home/Alex/lolcat.jpg")

	d := gomail.NewDialer("smtp.mxhichina.com", 465, "alert@fastonetech.com", "fnsU9XYqRV8A")

	// Send the email to Bob, Cora and Dan.
	if err := d.DialAndSend(m); err != nil {
		panic(err)
	}
}