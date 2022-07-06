package server

import (
	"encoding/json"
	"fmt"
	"go-http/dto"
	"log"
	"net/http"
)

func StartApp() {
	http.HandleFunc("/", test)
	err := http.ListenAndServe("127.0.0.1:9090", nil)
	log.Fatalln(err)
}

func test(w http.ResponseWriter, r *http.Request) {
	book := dto.Book{Id: 1, Title: "Book title", Preview: "Book preview", CreatedAt: 0}
	b, err := json.Marshal(book)
	if err == nil {
		w.WriteHeader(200)
		w.Write(b)
	} else {
		fmt.Println(err)
	}
}
