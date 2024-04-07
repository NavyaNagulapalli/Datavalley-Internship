class Organization implements Cloneable {
    private String organizationCode;
    private String organizationName;
    private String organizationAddress;

    public Organization(String code, String name, String address) {
        this.organizationCode = code;
        this.organizationName = name;
        this.organizationAddress = address;
    }

    // Method to print details
    public void printDetails() {
        System.out.println("Organization Code: " + organizationCode);
        System.out.println("Organization Name: " + organizationName);
        System.out.println("Organization Address: " + organizationAddress);
    }

    // Clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class CloningExample {
    public static void main(String[] args) {
        Organization org1 = new Organization("100", "X", "Address1");
        System.out.println("Original Object:");
        org1.printDetails();
        System.out.println();

        try {
            // Cloning the organization object
            Organization org2 = (Organization) org1.clone();

            // Printing cloned details
            System.out.println("Cloned Object:");
            org2.printDetails();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
