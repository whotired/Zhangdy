//package test;
//
//import test.com.ibm.swot.*;
//import test.com.ibm.swot.catalog.supply.*;
//import test.com.ibm.swot.controldata.*;
//import test.com.ibm.swot.eff.fulfillment.*;
//import test.com.ibm.swot.email.*;
//import test.com.ibm.swot.order.*;
//import test.com.ibm.swot.order.product.*;
//import test.com.ibm.swot.order.service.*;
//import test.com.ibm.swot.order.service.status.*;
//import test.com.ibm.swot.order.status.*;
//import test.com.ibm.swot.submitter.*;
//
//import junit.framework.Test;
//import junit.framework.TestSuite;
//
///**
// * TestSuite to test all TestCases
// * 
// * @author Andrew Wright [amwright@us.ibm.com]
// */
//public class AllTests {
//
//	public static Test suite() {
//		TestSuite suite = new TestSuite("Test for test.com.ibm.swot");
//		//$JUnit-BEGIN$
//		
//		// com.ibm.swot package
//		suite.addTest(new TestSuite(ShopzIDTest.class));
//		
//		// com.ibm.swot.catalog.supply package
//		suite.addTest(new TestSuite(MasterCatalogTest.class));
//		suite.addTest(new TestSuite(MCutilsTest.class));
//		suite.addTest(new TestSuite(OrderCatalogTest.class));
//		suite.addTest(new TestSuite(ProductCatalogTest.class));
//		suite.addTest(new TestSuite(RelModTest.class));
//		
//		// com.ibm.swot.controldata package
//		suite.addTest(new TestSuite(CountryTest.class));
//		suite.addTest(new TestSuite(MediaTest.class));
//		suite.addTest(new TestSuite(OpEnvTest.class));
//		suite.addTest(new TestSuite(ServiceLevelTest.class));
//		
//		// com.ibm.swot.eff.fulfillment package
//		suite.addTest(new TestSuite(FulfillmentCommunicatorTest.class));
//		suite.addTest(new TestSuite(ShowPurchaseOrderCallbackTest.class));
//		
//		// com.ibm.swot.email package
//		suite.addTest(new TestSuite(CustomerEmailTest.class));
//		
//		// com.ibm.swot.order package
//		suite.addTest(new TestSuite(CustomerNumberTest.class));
//		suite.addTest(new TestSuite(InventoryTest.class));
//		suite.addTest(new TestSuite(OrderFactoryTest.class));
//		suite.addTest(new TestSuite(OrderTest.class));
//		suite.addTest(new TestSuite(SpecialInstructionsTest.class));
//		
//		// com.ibm.swot.order.product package
//		suite.addTest(new TestSuite(VSLTest.class));
//		
//		// com.ibm.swot.order.service package
//		suite.addTest(new TestSuite(CorrectiveServiceOrderTest.class));
//		suite.addTest(new TestSuite(FMIDServiceOrderTest.class));
//		suite.addTest(new TestSuite(FMIDTest.class));
//		suite.addTest(new TestSuite(ProductServiceOrderTest.class));
//		suite.addTest(new TestSuite(ProfileServiceOrderTest.class));
//		suite.addTest(new TestSuite(ShipAddressTest.class));
//		suite.addTest(new TestSuite(shopccssTest.class));
//		suite.addTest(new TestSuite(shopccssRSUTest.class));
//		suite.addTest(new TestSuite(SubscriptionServiceOrderTest.class));
//		suite.addTest(new TestSuite(VMPSPBucketServiceOrderTest.class));
//		suite.addTest(new TestSuite(VMRSUServiceOrderTest.class));
//		suite.addTest(new TestSuite(VSEHiperServiceOrderTest.class));
//		suite.addTest(new TestSuite(ZoneServiceOrderTest.class));
//		
//		// com.ibm.swot.order.service.status package
//		suite.addTest(new TestSuite(ServiceOrderActiveStatusTest.class));
//		
//		// com.ibm.swot.order.status package
//		suite.addTest(new TestSuite(CancelledStatusTest.class));
//		suite.addTest(new TestSuite(DraftStatusTest.class));
//		suite.addTest(new TestSuite(PriceAvailableStatusTest.class));
//		
//		// com.ibm.swot.submitter package
//		suite.addTest(new TestSuite(ServiceOrderSubmitterTest.class));
//		
//		//$JUnit-END$
//		return suite;
//	}
//}
