//+------------------------------------------------------------------+
//|                                                 TradeMonitor.mq4 |
//|                        Copyright 2017, MetaQuotes Software Corp. |
//|                                             https://www.mql5.com |
//+------------------------------------------------------------------+
#property copyright "Copyright 2017, MetaQuotes Software Corp."
#property link      "https://www.mql5.com"
#property version   "1.00"
#property strict
//--- input parameters
input string   server;
input string   api_key;
//+------------------------------------------------------------------+
//| Expert initialization function                                   |
//+------------------------------------------------------------------+
int OnInit()
  {
//---
   
//---
   return(INIT_SUCCEEDED);
  }
//+------------------------------------------------------------------+
//| Expert deinitialization function                                 |
//+------------------------------------------------------------------+
void OnDeinit(const int reason)
  {
//---
   
  }
//+------------------------------------------------------------------+
//| Expert tick function                                             |
//+------------------------------------------------------------------+
void OnTick() {

   ResetLastError();
   int buy=FileOpen("buy.txt",FILE_SHARE_READ|FILE_CSV);
   if(buy!=INVALID_HANDLE){
     double lot = FileReadNumber(buy);
     FileClose(buy);
     FileDelete("buy.txt");
     OrderSend(Symbol(),OP_BUY,lot,Ask,2,0,0);
     Print("error",GetLastError());
   } else Print("error",GetLastError());
   

   ResetLastError();
   int sell=FileOpen("sell.txt",FILE_SHARE_READ|FILE_CSV);
   if(sell!=INVALID_HANDLE){
     double lot = FileReadNumber(sell);
     FileClose(sell);
     FileDelete("sell.txt");
     OrderSend(Symbol(),OP_SELL,lot,Bid,2,0,0);
     Print("error",GetLastError());
   } else Print("error",GetLastError());


   ResetLastError();
   int close=FileOpen("close.txt",FILE_SHARE_READ|FILE_CSV);
   if(close!=INVALID_HANDLE){
     for(int i=0; i<OrdersTotal(); i++){
       if (OrderSelect(i,SELECT_BY_POS)==true) {
         if (OrderType()==0)
            OrderClose(OrderTicket(),OrderLots(),Bid,2);          
         else OrderClose(OrderTicket(),OrderLots(),Ask,2);          
       }
     }
     FileClose(close);
     FileDelete("close.txt");
   } else Print("error",GetLastError());

 }
 

 