// Parent class
class Parent {
    void displayMessage() {
        System.out.println("Message from Parent class");
    }

    void displayMessage(String message) {
        System.out.println("Message from Parent class: " + message);
    }
}

// Child class
class Child extends Parent {
    // Method overriding
    @Override
    void displayMessage() {
        System.out.println("Message from Child class");
    }

    void displayMessage(int num) {
        System.out.println("Number from Child class: " + num);
    }
}

public class OverloadingAndOverridingDemo {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child = new Child();

        // Method overloading - Different parameter list
        parent.displayMessage(); // Invokes the method without parameter
        parent.displayMessage("Hello"); // Invokes the method with a String parameter

        // Method overriding
        child.displayMessage(); // Invokes the overridden method in Child class
        child.displayMessage(10); // Invokes the overloaded method in Child class
    }
}
