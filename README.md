# BookApp

# BookReview Mobile App

## Overview

The **BookReview Mobile App** is a simple mobile application designed to store and manage information about books. Users can add, update, delete, and view books and their attributes, such as ID, name, author, genre, and review ratings.

## Features

- **Home Screen:** 
  - Displays a list of all stored books in rows and columns.
  
- **Actions:**
  - **Create:** Users can add new books by clicking the "Create" button, which opens a new window to fill in book credentials (ID, Name, Author, Genre, and Reviews).
  - **Update:** Each book has an "Update" option. When clicked, a window pops up displaying the existing book details, allowing the user to edit and save the updated credentials.
  - **Delete:** Each book has a "Delete" option. Upon clicking, a confirmation pop-up appears asking the user to confirm the deletion.

## Book Attributes

Each book contains the following attributes:

1. **ID:** A unique identifier for each book.
2. **Name:** The title of the book.
3. **Author:** The name of the book's author.
4. **Genre:** The category or genre of the book (e.g., Fiction, Non-fiction, Mystery).
5. **Reviews:** A rating on a scale from 0 to 5 (e.g., 4.5).

## Data Storage

- All book data is stored in a local database, which updates as users perform create, update, or delete actions. 

## Requirements

### Functional Requirements:

1. **Create:** Users can add books with all attributes (ID, Name, Author, Genre, Reviews) by pressing a button that opens a form.
2. **Update:** Users can modify any attribute of a book by selecting the update option.
3. **Delete:** Users can remove a book from the list, with a confirmation prompt.
4. **Data Persistence:** The app uses a local database to store book data and must maintain its state across sessions.
