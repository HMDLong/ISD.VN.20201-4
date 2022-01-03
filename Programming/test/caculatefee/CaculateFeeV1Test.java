package caculatefee;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CaculateFeeV1Test {
	private CaculateFeeV1 classUnderTest;
	@BeforeEach
	void setUp() throws Exception {
		classUnderTest = new CaculateFeeV1();
	}

	@Test
	void testCaculateRentFee() {
		int result = (int)1.2 * 10000;
		assertEquals(result, classUnderTest.caculateRentFee("", (float)1.2));
		
		result = (int)2.6 * 10000;
		assertEquals(result, classUnderTest.caculateRentFee("", (float)2.6));
		result = 0 * 10000;
		assertEquals(result, classUnderTest.caculateRentFee("", 0));
	}

}
