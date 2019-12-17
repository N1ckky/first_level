package Nick_Maven.ErrorExeptions.ProjectPackage;

public class Group extends Faculty {
    private String groupName;

    public Group(String facultyName, String groupName) {
        super(facultyName);
        this.groupName = groupName;

    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public String toString() {
        return "Group [groupName=" + groupName + "]";
    }
}
