/*
 ----- BEGIN LICENSE BLOCK -----
 This Source Code Form is subject to the terms of the Mozilla Public License, v.2.0.
 If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.
 ----- END LICENSE BLOCK -----
 */
package org.pharmgkb.common.io.google;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * This is a JUnit test for {@link GoogleApiHelper}.
 *
 * @author Mark Woon
 */
public class GoogleApiHelperTest {

  @Test
  public void testStripKey() throws Exception {

    String expectedStrippedKey = "a+g+6D+Lre76kjnR1BtouK8aC/uKwIzR2Pn/VtBV6JmLEp+/5VY6uCorFzN6jOuF5JI490MqTYLV63nae8Ixy3JevZsja2jAsMOZwkRrgNzuTHt5Zztc5FhGc2AKvXS9UVC2orfw/7LCewDDxTHWLhIO8E4HbVm7U1jh8hwhzwNcTkk6/UvQX9mETufuTBbOSlte+wyeMdrkQpCQa2NmCmUUkPY2gEJJHw00HXhpFweG/DgT3A46pyKaWfPzh0Ss9hQAcQcdAgMBAAECggEBAItkNvXai044XcyeKiQyVZ6pTn1KZELss7WeUOu6cGj8Q58GBEZPIAe/3sq8iwLOAF3N4D9RqIqkmulS1cgU51Z9WCMFXXud6ygBqgR9Q0/2a/AnTFqGZ/QABku8Ewrw9YOw3aSp1OTCbgk4BN/P+pkqCcumcoRZyomkiyGJeM/eypYBLo886JnWJ/wncttK3D3GDgJw9gN5hs8YO2K97ka5urUeBmLG1ADIqogHDS1A3f0XvXboPLQkpbtR0g+v7IgAyLjqkXl5ab7AdNZgQvLHGTeiSrhlLb6d+KJNh9NebMmpChMVlk5V3kVHAYQ7Azud5JtIks5UizGyHZ4rHJECgYEA5aIF7kIbs0+KiEUuFCNsfjwlB9r+jGhka0atibUrZH6yWMpY0dyh8+KpZKIe8ksMcsphsBgTCBvb2waGTOcvhqAgv60f6ir6lZjoKiv9UKMCgYEAxVK1rujYTrCh0lZ3Se1qhIoqtrECtv7wfcdOkJb7pW1YPWHi16dxMOdgos1Ah8YDlrDpYVb3/cf1CfGxkVKFdAo2unCS8x95ikbIgm1Awo4eIb4xjijTWFxLeosOdzo1GCt7BNbW3eFbupUv/MbUsHEc0JkoRU9UCDrQ3jjNBT8CgYEAnQIdX/0fh4jZRbdXnEY1Mz4t+idw1jmdXA38k3aVfGfEoq7a+0Qyu2KPkLJDoePU86ctb1EN4+TlurTprpdR9TYWc7qO1V4DWz4mJcQT+VCPjRo9hLCAo4rVG5Ol6TDbQBmUlZzAVokF2EorxaVE353ZBnXPHoNodqToCP2u5FUCgYA0EqqtmPcUdRqPVpAua0AT8B5rjfUIc+jlWIaMM7v/IQcLU9y4SpDddgITlJT1/7SMvO0p6fiR+YXZ9PWGQz/Cqrtcoj61eFXrvthFSy2u6jBbeUS8nlt/0wN8OFw97Jd8ZGUXltanQUSizaIXVCVm1sLi7bgp6lBjx5m9O0InowKBgQDL9RX6dDAZ1oOREhv8dBIVJT77NMoFF/w4yRWWyBikUzIspU0dCpyPnLs0+rlQMDHBQlIKKEfRJsxBDJOUuZNdkumkszLllyHadcOwRIYRKnRE6c8M/EXRW2WWKlz59+/8SnnjvUt/jM0i4BwqVOAw5FABxuT+/E/MQRl5j94n8w==";

    String key = "-----BEGIN PRIVATE KEY-----\n" +
        "a+g+6D+Lre76kjnR1BtouK8aC/uKwIzR2Pn/VtBV6JmLEp+/5VY6uCorFzN6jOuF\n" +
        "5JI490MqTYLV63nae8Ixy3JevZsja2jAsMOZwkRrgNzuTHt5Zztc5FhGc2AKvXS9\n" +
        "UVC2orfw/7LCewDDxTHWLhIO8E4HbVm7U1jh8hwhzwNcTkk6/UvQX9mETufuTBbO\n" +
        "Slte+wyeMdrkQpCQa2NmCmUUkPY2gEJJHw00HXhpFweG/DgT3A46pyKaWfPzh0Ss\n" +
        "9hQAcQcdAgMBAAECggEBAItkNvXai044XcyeKiQyVZ6pTn1KZELss7WeUOu6cGj8\n" +
        "Q58GBEZPIAe/3sq8iwLOAF3N4D9RqIqkmulS1cgU51Z9WCMFXXud6ygBqgR9Q0/2\n" +
        "a/AnTFqGZ/QABku8Ewrw9YOw3aSp1OTCbgk4BN/P+pkqCcumcoRZyomkiyGJeM/e\n" +
        "ypYBLo886JnWJ/wncttK3D3GDgJw9gN5hs8YO2K97ka5urUeBmLG1ADIqogHDS1A\n" +
        "3f0XvXboPLQkpbtR0g+v7IgAyLjqkXl5ab7AdNZgQvLHGTeiSrhlLb6d+KJNh9Ne\n" +
        "bMmpChMVlk5V3kVHAYQ7Azud5JtIks5UizGyHZ4rHJECgYEA5aIF7kIbs0+KiEUu\n" +
        "FCNsfjwlB9r+jGhka0atibUrZH6yWMpY0dyh8+KpZKIe8ksMcsphsBgTCBvb2waG\n" +
        "TOcvhqAgv60f6ir6lZjoKiv9UKMCgYEAxVK1rujYTrCh0lZ3Se1qhIoqtrECtv7w\n" +
        "fcdOkJb7pW1YPWHi16dxMOdgos1Ah8YDlrDpYVb3/cf1CfGxkVKFdAo2unCS8x95\n" +
        "ikbIgm1Awo4eIb4xjijTWFxLeosOdzo1GCt7BNbW3eFbupUv/MbUsHEc0JkoRU9U\n" +
        "CDrQ3jjNBT8CgYEAnQIdX/0fh4jZRbdXnEY1Mz4t+idw1jmdXA38k3aVfGfEoq7a\n" +
        "+0Qyu2KPkLJDoePU86ctb1EN4+TlurTprpdR9TYWc7qO1V4DWz4mJcQT+VCPjRo9\n" +
        "hLCAo4rVG5Ol6TDbQBmUlZzAVokF2EorxaVE353ZBnXPHoNodqToCP2u5FUCgYA0\n" +
        "EqqtmPcUdRqPVpAua0AT8B5rjfUIc+jlWIaMM7v/IQcLU9y4SpDddgITlJT1/7SM\n" +
        "vO0p6fiR+YXZ9PWGQz/Cqrtcoj61eFXrvthFSy2u6jBbeUS8nlt/0wN8OFw97Jd8\n" +
        "ZGUXltanQUSizaIXVCVm1sLi7bgp6lBjx5m9O0InowKBgQDL9RX6dDAZ1oOREhv8\n" +
        "dBIVJT77NMoFF/w4yRWWyBikUzIspU0dCpyPnLs0+rlQMDHBQlIKKEfRJsxBDJOU\n" +
        "uZNdkumkszLllyHadcOwRIYRKnRE6c8M/EXRW2WWKlz59+/8SnnjvUt/jM0i4Bwq\n" +
        "VOAw5FABxuT+/E/MQRl5j94n8w==\n" +
        "-----END PRIVATE KEY-----\n";
    assertEquals(expectedStrippedKey, GoogleApiHelper.stripKey(key));

    key = "a+g+6D+Lre76kjnR1BtouK8aC/uKwIzR2Pn/VtBV6JmLEp+/5VY6uCorFzN6jOuF\r\n" +
        "5JI490MqTYLV63nae8Ixy3JevZsja2jAsMOZwkRrgNzuTHt5Zztc5FhGc2AKvXS9\r\n" +
        "UVC2orfw/7LCewDDxTHWLhIO8E4HbVm7U1jh8hwhzwNcTkk6/UvQX9mETufuTBbO\r\n" +
        "Slte+wyeMdrkQpCQa2NmCmUUkPY2gEJJHw00HXhpFweG/DgT3A46pyKaWfPzh0Ss\r\n" +
        "9hQAcQcdAgMBAAECggEBAItkNvXai044XcyeKiQyVZ6pTn1KZELss7WeUOu6cGj8\r\n" +
        "Q58GBEZPIAe/3sq8iwLOAF3N4D9RqIqkmulS1cgU51Z9WCMFXXud6ygBqgR9Q0/2\r\n" +
        "a/AnTFqGZ/QABku8Ewrw9YOw3aSp1OTCbgk4BN/P+pkqCcumcoRZyomkiyGJeM/e\r\n" +
        "ypYBLo886JnWJ/wncttK3D3GDgJw9gN5hs8YO2K97ka5urUeBmLG1ADIqogHDS1A\r\n" +
        "3f0XvXboPLQkpbtR0g+v7IgAyLjqkXl5ab7AdNZgQvLHGTeiSrhlLb6d+KJNh9Ne\r\n" +
        "bMmpChMVlk5V3kVHAYQ7Azud5JtIks5UizGyHZ4rHJECgYEA5aIF7kIbs0+KiEUu\r\n" +
        "FCNsfjwlB9r+jGhka0atibUrZH6yWMpY0dyh8+KpZKIe8ksMcsphsBgTCBvb2waG\r\n" +
        "TOcvhqAgv60f6ir6lZjoKiv9UKMCgYEAxVK1rujYTrCh0lZ3Se1qhIoqtrECtv7w\r\n" +
        "fcdOkJb7pW1YPWHi16dxMOdgos1Ah8YDlrDpYVb3/cf1CfGxkVKFdAo2unCS8x95\r\n" +
        "ikbIgm1Awo4eIb4xjijTWFxLeosOdzo1GCt7BNbW3eFbupUv/MbUsHEc0JkoRU9U\r\n" +
        "CDrQ3jjNBT8CgYEAnQIdX/0fh4jZRbdXnEY1Mz4t+idw1jmdXA38k3aVfGfEoq7a\r\n" +
        "+0Qyu2KPkLJDoePU86ctb1EN4+TlurTprpdR9TYWc7qO1V4DWz4mJcQT+VCPjRo9\r\n" +
        "hLCAo4rVG5Ol6TDbQBmUlZzAVokF2EorxaVE353ZBnXPHoNodqToCP2u5FUCgYA0\r\n" +
        "EqqtmPcUdRqPVpAua0AT8B5rjfUIc+jlWIaMM7v/IQcLU9y4SpDddgITlJT1/7SM\r\n" +
        "vO0p6fiR+YXZ9PWGQz/Cqrtcoj61eFXrvthFSy2u6jBbeUS8nlt/0wN8OFw97Jd8\r\n" +
        "ZGUXltanQUSizaIXVCVm1sLi7bgp6lBjx5m9O0InowKBgQDL9RX6dDAZ1oOREhv8\r\n" +
        "dBIVJT77NMoFF/w4yRWWyBikUzIspU0dCpyPnLs0+rlQMDHBQlIKKEfRJsxBDJOU\r\n" +
        "uZNdkumkszLllyHadcOwRIYRKnRE6c8M/EXRW2WWKlz59+/8SnnjvUt/jM0i4Bwq\r\n" +
        "VOAw5FABxuT+/E/MQRl5j94n8w==\r\n";
    assertEquals(expectedStrippedKey, GoogleApiHelper.stripKey(key));

  }
}
