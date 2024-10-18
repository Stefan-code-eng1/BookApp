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

## Offline
### Create Operation (Add a New Book)
Scenario:

The user attempts to add a new book while the device is offline.
Offline Behavior:

When the user clicks the "Create" button, the app still allows the user to fill in the book details (ID, Name, Author, Genre, Reviews) in the form.
Instead of instantly sending the data to the remote database or server, the app saves the new book entry locally in the device's storage (using local database, such as SQLite or a cache).
Once the device comes back online, the app will synchronize the locally stored book with the remote database, adding it to the central repository.
Error Handling:

Display a message like:
"You are offline. Your book entry will be saved locally and uploaded when the connection is restored."

### Read Operation (View Books List)
Scenario:

The user tries to view the list of books while offline.
Offline Behavior:

The app retrieves and displays the book data that is stored locally on the device. Since no new data can be fetched from the remote server while offline, the user can only view previously cached books (those that were loaded while the device was online).
If no local data exists (for example, if the app is newly installed and the user has never been online), the app displays a message stating that no data is available due to lack of connection.
Error Handling:

Display a message like:
"You are offline. Showing the locally saved book list. Connect to the internet for the latest updates."

### Update Operation (Edit a Book's Details)
Scenario:

The user attempts to update a book's information while the device is offline.
Offline Behavior:

The user is able to open the book’s details and modify the information (e.g., change the title, author, or rating).
The changes are saved locally on the device instead of syncing immediately with the remote database.
Once the device goes back online, the app synchronizes the locally updated information with the remote database, updating the book record globally.
Error Handling:

Display a message like:
"You are offline. The changes you made will be saved locally and updated once you're back online."
### Delete Operation (Remove a Book)
Scenario:

The user attempts to delete a book from the list while the device is offline.
Offline Behavior:

The app allows the user to delete the book from the local list, and it is removed from the display immediately.
However, the deletion is only marked locally. The book is not actually removed from the remote database until the device is online.
Once the device reconnects, the app synchronizes with the remote server and removes the book from the central database.
Error Handling:

Display a message like:
"You are offline. The book will be deleted once you're back online. It may still appear if you reconnect to the server before deletion syncs."
