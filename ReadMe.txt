Read Me ---  The Big Diwali Sale:  ---------

Step 1: import maven project in eclipse / STS
		run the SpringBoot project


Step 2: open postman

		import "Big Diwali Sale.postman_collection.json" file in POSTMAN

		POST  http://localhost:8080/maximizeDiscount?rule=1
		body raw Json    [10,20,30,40,50,50,60]

		POST  http://localhost:8080/maximizeDiscount?rule=2
		body raw Json    [10,20,30,40,40,50,60,60]

		POST  http://localhost:8080/maximizeDiscount?rule=3
		body raw Json    [10,20,30,40,40,50,60,60]
