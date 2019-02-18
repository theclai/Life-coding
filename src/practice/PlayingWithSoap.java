package practice;

import com.sun.xml.internal.messaging.saaj.soap.ver1_1.SOAPMessageFactory1_1Impl;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PlayingWithSoap {
    public static void main(String[] args) throws SOAPException, IOException {
        String soapEndpointUrl = "https://stagegateway.rpx.realpage.com/rpxgateway/partner/ILM/IntelligentLeadManagement.svc";
        String soapAction = "http://tempuri.org/IRPXService/createquote";

        callSoapWebService(soapEndpointUrl, soapAction);

    }


    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();

            SOAPConnection soapConnection = soapConnectionFactory.createConnection();


            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(soapAction), soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        //System.out.println("Request SOAP Message:");
       // soapMessage.writeTo(System.out);
       // System.out.println("\n");

        return soapMessage;
    }

    private static void createSoapEnvelope(SOAPMessage message) throws SOAPException, IOException {
        SOAPPart soapPart=message.getSOAPPart();

        String myNamespace = "tem";
        String myNamespaceURI = "http://tempuri.org/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

        SOAPBody body=envelope.getBody();
        SOAPElement createQuoteElement=body.addChildElement("createquote",myNamespace);
        SOAPElement authElement=createQuoteElement.addChildElement("auth",myNamespace);
        SOAPElement pmcIdElement= authElement.addChildElement("pmcid",myNamespace);
        pmcIdElement.addTextNode(String.valueOf(7111939));

        SOAPElement siteIdElement= authElement.addChildElement("siteId",myNamespace);
        siteIdElement.addTextNode(String.valueOf(7111950));

        SOAPElement usernameElement= authElement.addChildElement("username",myNamespace);
        usernameElement.addTextNode("ILM");

        SOAPElement passwordElement= authElement.addChildElement("password",myNamespace);
        passwordElement.addTextNode("Y7UbhuMh");

        SOAPElement licenceKeyElement= authElement.addChildElement("licensekey",myNamespace);
        licenceKeyElement.addTextNode("52253bc1-4180-45d7-8b20-ed1d3919b128");

        SOAPElement systemElement= authElement.addChildElement("system",myNamespace);
        systemElement.addTextNode("OneSite");
        //-------------------******************--------------------
        /*
        SOAPElement quoteElement= createQuoteElement.addChildElement("quote",myNamespace);

        SOAPElement guestCardIdElement=quoteElement.addChildElement("guestcardid",myNamespace);
        guestCardIdElement.addTextNode(String.valueOf(31019014));

        SOAPElement leasetermmonths=quoteElement.addChildElement("leasetermmonths",myNamespace);
        leasetermmonths.addTextNode("12");

        SOAPElement quoteid=quoteElement.addChildElement("quoteid",myNamespace);
        quoteid.addTextNode(String.valueOf(0));


        SOAPElement deposit=quoteElement.addChildElement("deposit",myNamespace);
        deposit.addTextNode(String.valueOf(407));


        SOAPElement expirationdate=quoteElement.addChildElement("expirationdate",myNamespace);
        expirationdate.addTextNode("2019-03-20");



        SOAPElement leasestartdate=quoteElement.addChildElement("leasestartdate",myNamespace);
        leasestartdate.addTextNode("2019-02-28");


        SOAPElement moveindate=quoteElement.addChildElement("moveindate",myNamespace);
        moveindate.addTextNode("2019-02-28");


        SOAPElement rent=quoteElement.addChildElement("rent",myNamespace);
        rent.addTextNode(String.valueOf(2035));


        SOAPElement leasingagentid=quoteElement.addChildElement("leasingagentid",myNamespace);
        leasingagentid.addTextNode(String.valueOf(31019014));

        SOAPElement unit=quoteElement.addChildElement("unit",myNamespace);
        unit.addTextNode(String.valueOf(81));

        SOAPElement building=quoteElement.addChildElement("building",myNamespace);
        building.addTextNode(String.valueOf(4));
*/
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        message.writeTo(out);
        System.out.println(new String(String.valueOf(out)));

    }
}
