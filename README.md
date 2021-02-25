# Warehouseman

The application for managing the receiving of products into
the warehouse and the release of products to the outside
##General Info

It was established that all products are on pallets.
Each pallet can always contain the same quantity of a 
given product. The main unit for quantity records is
the pallet.

At the beginning you need to log in as a warehouseman
(user); the password for each user is now set to
###000

The main application window consists of several panes.
###Products Pane

These are products that can be taken into and out
of the warehouse.

You can add a new product, edit the product and remove it.
You can also search for products by entering the 
appropriate phrase in the text field.
###Inventory Pane

The pane shows the quantity of products that are currently 
in stock. You can search for items using the text field.
###Shippers Pane

The pane concerns shippers who are responsible for
transporting products to the customer from the warehouse. 
The operation of the pane is similar to that of the product pane.
###Product Receive Pane

The pane concerns receiving products on pallets 
to the warehouse. Select the product, enter the number of pallets
of the received product and confirm with the appropriate button. 

It is possible to view the history of all previous products received 
into the warehouse.
Details about the product, and the warehouseman (user) who received 
the products are also available there.
###Product Release Pane

The pane concerns the release of products to the outside.
It is similar to the previous pane. However, the shipper should be
included here.
###Warehouseman Pane

The panel shows the currently logged in the warehouseman (user). 
Here you can log out the user to log in another.
##Technologies
- Java 15
- JavaFX 15
- Apache Maven
