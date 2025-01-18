package main
import (
  "fmt"
  "bufio"
  "os"
  "strings"
)

func main() {

  // Arrays (Acting as a Database)
  NameDb := []string{}
  IdDb   := []string{}
  SectionDb := []string{}

  // Scanner input 
  scanner := bufio.NewScanner(os.Stdin)

  // Student Name
  fmt.Print("Enter Student Name: ")
  scanner.Scan()
  var Name string = scanner.Text()
  NameDb = append(NameDb, Name)


  // Student ID
  fmt.Print("Enter Student ID: ")
  scanner.Scan()
  var ID string = scanner.Text()
  IdDb = append(IdDb, ID)


  // Student Section
  fmt.Print("Enter Student Section: ")
  scanner.Scan()
  var Section string = scanner.Text()
  SectionDb = append(SectionDb, Section)

  fmt.Print("Search: ")
  scanner.Scan()
  searchVal := scanner.Text()

  searchVal = strings.ToLower(searchVal)

  // Linear search to find a value on the array
  found := false
  for i := 0; i < len(IdDb); i++ {
    if strings.ToLower(IdDb[i]) == searchVal {
      fmt.Printf("Found Student: \nName: %s\nID: %s\nSection: %s\n", NameDb[i], IdDb[i], SectionDb[i])
      found = true
      break 
    }
  } 

  // if not found return this message
  if !found {
    fmt.Println("Student not found")
  }

}
