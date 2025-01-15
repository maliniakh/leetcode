package tasks;

import java.util.Arrays;
import java.util.Comparator;

public class CityIPMapping {
    static class IPRange {
        String city;
        long startIP;
        long endIP;

        IPRange(String city, long startIP, long endIP) {
            this.city = city;
            this.startIP = startIP;
            this.endIP = endIP;
        }
    }

    public static void main(String[] args) {
        // Define IP ranges
        IPRange[] ipRanges = new IPRange[] {
                new IPRange("CityA", ipToLong("192.168.0.0"), ipToLong("192.168.0.255")),
                new IPRange("CityB", ipToLong("192.168.1.0"), ipToLong("192.168.1.255")),
                new IPRange("CityC", ipToLong("192.168.2.0"), ipToLong("192.168.2.255"))
        };

        // Sort the array by startIP
        Arrays.sort(ipRanges, Comparator.comparingLong(range -> range.startIP));

        // Test IP
        String ip = "192.168.1.50";
        String city = getCityByIP(ipRanges, ip);
        System.out.println("City: " + city);
    }

    public static String getCityByIP(IPRange[] ipRanges, String ip) {
        long ipLong = ipToLong(ip);

        // Use built-in binary search with a custom comparator
        int index = Arrays.binarySearch(ipRanges, new IPRange(null, ipLong, ipLong),
                (range, key) -> {
                    if (key.startIP >= range.startIP && key.startIP <= range.endIP) {
                        return 0; // Found the range
                    }
                    return Long.compare(key.startIP, range.startIP);
                });

        // Handle the binary search result
        if (index >= 0) {
            return ipRanges[index].city;
        }

        return "Unknown";
    }

    public static long ipToLong(String ip) {
        String[] octets = ip.split("\\.");
        return (Long.parseLong(octets[0]) << 24) |
                (Long.parseLong(octets[1]) << 16) |
                (Long.parseLong(octets[2]) << 8)  |
                Long.parseLong(octets[3]);
    }
}

