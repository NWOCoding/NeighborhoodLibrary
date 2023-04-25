
# Neighborhood Library Application

This is an application for a neighborhood library that allows anyone to check out a book based on the honor system. The application keeps track of who checked out a book and when it was checked in.

## Requirements

The application is built using Java and meets the following requirements:

* Use an array to hold an inventory of at least 5 books of your choice.
* When a book is checked out:
    * the book's `checkedOutTo` variable should be set to the name provided
    * the `isCheckedOut` variable should be set to true
* When a book is checked in:
    * the book's `checkedOutTo` variable should be set to an empty string
    * the `isCheckedOut` variable should be set to false

## Screens

The application has the following screens:

### Store Home Screen

The home screen displays a list of options that a user can choose from:

* Show Available Books
* Show Checked Out Books
* Exit - closes out of the application

### Show Available Books

Displays a list of all books that are not currently checked out. The screen displays the `id`, `isbn`, and `title` of each book. 

The user is prompted to either select a book to check out or exit to go back to the home screen. If the user wants to check out a book, they are prompted for their name. Then the book is checked out to them.

### Show Checked Out Books

Displays a list of all the books that are currently checked out. The screen displays the `id`, `isbn`, `title`, and `name` of the person who has the book checked out. 

The user is prompted to either check in a book or go back to the home screen.

### Check In a Book

Prompts the user for the `id` of the book they want to check in. The book is checked in with the specified `id` and the user is taken back to the home screen.
