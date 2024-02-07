<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>

<html>

<head>
  <meta charset="UTF-8">
  <title>books</title>
  <style>
    #left {
      width: 50%;
      height: 100vh;
      background-color: lightgray;
      float: left;
    }

    #right {
      width: 50%;
      height: 100vh;
      background-color: lightblue;
      float: left;
    }

    .bookDetails {
      display: flex;
      flex-direction: column;
      align-items: flex-start;
      height: 100%;
      width: 100%;
      padding: 10px;
    }

    .book {
      display: flex;
      flex-direction: column;
      align-items: center;
      text-align: center;
      margin-bottom: 10px;
      display: flex;
      align-items: center;
    }

    .book p {
      margin-right: 10px;
      display: inline;
    }
  </style>
</head>

<body>
  <div class="outer">
    <div class="inner" id="left">
      <div class="bookDetails">
        <div class="book">
          <p id="book1">book1 <button onclick="addToCart('book1')">add to cart</button> <button onclick="removeFromCart('book1')">remove</button></p>
        </div>
        <div class="book">
          <p id="book2">book2 <button onclick="addToCart('book2')">add to cart</button><button onclick="removeFromCart('book2')">remove</button></p>
        </div>
      </div>
    </div>
    <div class="inner" id="right">

    </div>
  </div>

  <script>
  function addToCart(bookId) {
	  var bookElement = document.getElementById(bookId);
	  var bookName = bookElement.parentElement.innerText.split(" ")[0];
	  var rightSection = document.getElementById("right");
	  var newDiv = document.createElement("div");
	  newDiv.id = bookId;
	  newDiv.textContent = bookName;
	  
	  // Check if book is already present in the right section
	  var present = false;
	  var books = rightSection.getElementsByTagName("div");
	  for (var i = 0; i < books.length; i++) {
	    if (books[i].textContent.trim() === bookName) {
	      present = true;
	      break;
	    }
	  }

	  // Append child if not already present
	  if (!present) {
	    rightSection.appendChild(newDiv);
	  }
	}

	function removeFromCart(bookId) {
	  var bookElement = document.getElementById(bookId);
	  var bookName = bookElement.parentElement.innerText.split(" ")[0];
	  var rightSection = document.getElementById("right");
	  var books = rightSection.getElementsByTagName("div");
	  for (var i = 0; i < books.length; i++) {
	    if (books[i].textContent.trim() === bookName) {
	      rightSection.removeChild(books[i]);
	      break;
	    }
	  }
	}

  </script>
</body>

</html>
