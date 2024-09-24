package exp3;
import java.util.HashMap;
import java.util.Map;

class ARPTable {
    private Map<String, String> arpTable;

    public ARPTable() {
        arpTable = new HashMap<>();
    }

    public void addEntry(String ipAddress, String macAddress) {
        arpTable.put(ipAddress, macAddress);
    }

    public String lookupMAC(String ipAddress) {
        return arpTable.get(ipAddress);
    }

    public String lookupIP(String macAddress) {
        for (Map.Entry<String, String> entry : arpTable.entrySet()) {
            if (entry.getValue().equals(macAddress)) {
                return entry.getKey();
            }
        }
        return null;
    }
}

public class experiment3 {
    public static void main(String[] args) {
        ARPTable arpTable = new ARPTable();

        // Adding entries to the ARP Table
        arpTable.addEntry("192.168.1.1", "00:14:22:01:23:45");
        arpTable.addEntry("192.168.1.2", "00:14:22:01:23:46");
        arpTable.addEntry("192.168.1.3", "00:14:22:01:23:47");

        // Simulate ARP request and response
        String ipToLookup = "192.168.1.2";
        String macAddress = arpTable.lookupMAC(ipToLookup);
        if (macAddress != null) {
            System.out.println("ARP Response: MAC address for IP " + ipToLookup + " is " + macAddress);
        } else {
            System.out.println("ARP Response: IP address " + ipToLookup + " not found in ARP table.");
        }

        // Simulate RARP request and response
        String macToLookup = "00:14:22:01:23:47";
        String ipAddress = arpTable.lookupIP(macToLookup);
        if (ipAddress != null) {
            System.out.println("RARP Response: IP address for MAC " + macToLookup + " is " + ipAddress);
        } else {
            System.out.println("RARP Response: MAC address " + macToLookup + " not found in ARP table.");
        }
    }
}
