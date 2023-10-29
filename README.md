# MatchingEngine

Structure of the application:

1) Initial Build -> Bootstrap(Sample order loading)

2) Controller(API Path Mapping) -> Service(Interface) -> Service(Implementation) -> Repository(Queries to the H2 Database)

3) Buyers and Sellers Matching logic: Minimum Selling Price >= Maximum Buying Price
   Currently, the application hosts 2 tickers: TATA & RELIANCE.

4) API :
  a) localhost:8080/api/v1/orderstock/getOrders : This fetches all the orders based on the Stock Status (Options: COMPLETED/PENDING)
  b) localhost:8080/api/v1/orderstock/matchOrders : This matches all the orders with PENDING status according to the business logic mentioned above.

5) Queries used in the repository are to fetch orders according to the logic and update the status if a match is found.

   
