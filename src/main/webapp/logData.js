angular.module('app').constant('source', ` // <- This ISN’T a quote, is a backquote
--------- SCRIPT CALL STACKS ----------
  TOTAL     AVERAGE     LONGEST    SHORTEST       COUNT  ELEMENT
  millisec     microsec    microsec    microsec
 54,475  54,473,484  54,473,484  54,473,484            1  om.service.omapiJSBinding/createOrder.cwONJsProvider
 54,473  54,473,275  54,473,275  54,473,275            1  . om.service.createOrderBindingScript
 53,919  53,919,962  53,919,962  53,919,962            1  . . om.service.createOrder
 53,918  53,918,776  53,918,776  53,918,776            1  . . . cwl_om.createOrder
 34,124   2,007,294   3,431,160     703,338           17  . . . . cwt_do.setTreeCharacteristics
 15,752     926,636   1,945,801     347,506           17  . . . . . dataorder.service.updateOrder 
 15,752     926,598   1,945,778     347,448           17  . . . . . . cwt_do.api.updateOrderHandler 
 17,723   1,042,576   1,495,030     553,801           17  . . . . dataorder.service.addOrderltem 
  1,915   1,915,023   1,915,023   1,915,023            1  . . . . dataorder.service.createOrder 
 52,605   1,948,336  15,978,980      79,434           27  Start.waitForFlowCompletion.complete.cwOnProcActBefore 
 52,603   1,948,267  15,978,926      79,382           27  . cwl_om.decompositionProcessComplete 
`);
		