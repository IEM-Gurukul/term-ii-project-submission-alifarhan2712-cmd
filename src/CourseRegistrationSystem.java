import java.util.*;

// Component
interface CourseModule {
    void showDetails();
    int getCredits();
    String getName();
}

// Leaf
class IndividualCourse implements CourseModule {
    private String name;
    private int credits;

    public IndividualCourse(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public void showDetails() {
        System.out.println(name + " (" + credits + " credits)");
    }

    public int getCredits() {
        return credits;
    }

    public String getName() {
        return name;
    }
}

// Composite
class CourseGroup implements CourseModule {
    private String name;
    private List<CourseModule> modules = new ArrayList<>();

    public CourseGroup(String name) {
        this.name = name;
    }

    public void addModule(CourseModule module) {
        modules.add(module);
    }

    public List<CourseModule> getModules() {
        return modules;
    }

    public void showDetails() {
        System.out.println("\n" + name + ":");
        for (CourseModule m : modules) {
            m.showDetails();
        }
    }

    public int getCredits() {
        int total = 0;
        for (CourseModule m : modules) {
            total += m.getCredits();
        }
        return total;
    }

    public String getName() {
        return name;
    }
}

// Main System
public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create courses
        IndividualCourse math = new IndividualCourse("Mathematics", 4);
        IndividualCourse physics = new IndividualCourse("Physics", 3);
        IndividualCourse java = new IndividualCourse("Java Programming", 5);
        IndividualCourse ai = new IndividualCourse("Artificial Intelligence", 4);

        // Groups
        CourseGroup core = new CourseGroup("Core Courses");
        core.addModule(math);
        core.addModule(physics);

        CourseGroup advanced = new CourseGroup("Advanced Courses");
        advanced.addModule(java);
        advanced.addModule(ai);

        // All courses list
        List<CourseModule> allCourses = new ArrayList<>();
        allCourses.addAll(core.getModules());
        allCourses.addAll(advanced.getModules());

        // Student selected courses
        List<CourseModule> selectedCourses = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Course Registration System =====");
            System.out.println("1. View Courses");
            System.out.println("2. Register Course");
            System.out.println("3. View Selected Courses");
            System.out.println("4. Total Credits");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    core.showDetails();
                    advanced.showDetails();
                    break;

                case 2:
                    System.out.println("\nAvailable Courses:");
                    for (int i = 0; i < allCourses.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        allCourses.get(i).showDetails();
                    }

                    System.out.print("Enter course number to register: ");
                    int courseChoice = sc.nextInt();

                    if (courseChoice >= 1 && courseChoice <= allCourses.size()) {
                        CourseModule selected = allCourses.get(courseChoice - 1);
                        if (!selectedCourses.contains(selected)) {
                            selectedCourses.add(selected);
                            System.out.println("Course added successfully!");
                        } else {
                            System.out.println("Already registered!");
                        }
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 3:
                    System.out.println("\nYour Courses:");
                    if (selectedCourses.isEmpty()) {
                        System.out.println("No courses selected.");
                    } else {
                        for (CourseModule c : selectedCourses) {
                            c.showDetails();
                        }
                    }
                    break;

                case 4:
                    int total = 0;
                    for (CourseModule c : selectedCourses) {
                        total += c.getCredits();
                    }
                    System.out.println("Total Credits: " + total);
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option!");
            }

        } while (choice != 0);

        sc.close();
    }
}