package com.example.walkwithme;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RetrieveEvents {
    public ArrayList<Events> events;

    public RetrieveEvents (ArrayList<Events> events) {this.events = events; }

    public void saveXML(File file) throws TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document d = db.newDocument();

            //root element
            Element root = d.createElement("events");
            d.appendChild(root);

            for (Events event: events) {
                //event element
                Element eventDetail = d.createElement("event");
                root.appendChild(eventDetail);

                //set attribute id of event
                Attr id = d.createAttribute("eventID");
                id.setValue(String.valueOf(event.eventID));
                eventDetail.setAttributeNode(id);

                // eventName element
                Element eventName = d.createElement("eventName");
                eventName.appendChild(d.createTextNode(event.eventName));
                eventDetail.appendChild(eventName);

                //eventDescription element
                Element eventDescription = d.createElement("eventDescription");
                eventDescription.appendChild(d.createTextNode(event.eventDescription));
                eventDetail.appendChild(eventDescription);

                //eventStartDate element
                Element eventStartDate = d.createElement("eventStartDate");
                eventStartDate.appendChild(d.createTextNode(event.eventStartDate));
                eventDetail.appendChild(eventStartDate);

                //eventEndDate element
                Element eventEndDate = d.createElement("eventEndDate");
                eventEndDate.appendChild(d.createTextNode(event.eventEndDate));
                eventDetail.appendChild(eventEndDate);

                //latitude element
                Element latitude = d.createElement("latitude");
                latitude.appendChild(d.createTextNode(String.valueOf(event.latitude)));
                eventDetail.appendChild(latitude);

                //longitude element
                Element longitude = d.createElement("longitude");
                longitude.appendChild(d.createTextNode(String.valueOf(event.longitude)));
                eventDetail.appendChild(longitude);

                //maxParticipants element
                Element maxParticipants = d.createElement("maxParticipants");
                maxParticipants.appendChild(d.createTextNode(String.valueOf(event.maxParticipants)));
                eventDetail.appendChild(maxParticipants);

                //creationUserID element
                Element creationUserID = d.createElement("creationUserID");
                creationUserID.appendChild(d.createTextNode(String.valueOf(event.maxParticipants)));
                eventDetail.appendChild(creationUserID);

                //likeCount element
                Element eventActiveStatus = d.createElement("eventActiveStatus");
                eventActiveStatus.appendChild(d.createTextNode(String.valueOf(event.eventActiveStatus)));
                eventDetail.appendChild(eventActiveStatus);
            }
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(d);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws TransformerException {
        RetrieveEvents events = new RetrieveEvents(new ArrayList<>());

        int eventID;
        List<String> eventNames = Arrays.asList("Running", "Walking", "Hiking", "Studying", "Swimming");
        List<String> eventDescriptions = Arrays.asList("with me and my friends", "with me", "3 in total", "4 in total");
        List<String> eventStartDates = Arrays.asList("2021/10/21", "2021/10/22", "2021/10/23", "2021/10/24", "2021/10/25");
        List<String> eventEndDates = Arrays.asList("2021/10/26", "2021/10/27", "2021/10/28", "2021/10/29", "2021/10/30");
        List<Float> latitudes = Arrays.asList(-35.2735f, -35.2790f, -35.2800f, -35.2835f, -35.2860f);
        List<Float> longitudes = Arrays.asList(149.1121f, 149.1135f, 149.1160f, 149.1185f, 149.1199f, 149.1249f);
        List<Integer> creationUserIDs = Arrays.asList(1,2,3,4,5,6);

        for (int i=1; i<=1000; i++) {
            Random random = new Random();
            int indexEventName = random.nextInt(eventNames.size());
            int indexEventDes = random.nextInt(eventDescriptions.size());
            int indexEventStart = random.nextInt(eventStartDates.size());
            int indexEventEnd = random.nextInt(eventEndDates.size());
            int indexLatitude = random.nextInt(latitudes.size());
            int indexLongitude = random.nextInt(longitudes.size());
            int indexCreationUserIDs = random.nextInt(creationUserIDs.size());

            eventID = i;
            String eventName = eventNames.get(indexEventName);
            String eventDescription = eventDescriptions.get(indexEventDes);
            String eventStartDate = eventStartDates.get(indexEventStart);
            String eventEndDate = eventEndDates.get(indexEventEnd);
            Float latitude = latitudes.get(indexLatitude);
            Float longitude = longitudes.get(indexLongitude);
            int creationUserID = creationUserIDs.get(indexCreationUserIDs);
            int maxParticipants = random.nextInt(2) + 2;
            Boolean eventActiveStatus = random.nextBoolean();

            Events event = new Events(eventID, eventName, eventDescription,eventStartDate,eventEndDate,latitude,
                    longitude,maxParticipants,creationUserID,eventActiveStatus);
            events.events.add(event);

        }
        File file = new File("events.xml");
        events.saveXML(file);
    }
}
