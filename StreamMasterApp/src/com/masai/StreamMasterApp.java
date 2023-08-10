
package com.masai;

import java.util.*;

class User {
    private String name;
    private String email;
    private String contactNumber;
    private String username;
    private String password;
    private List<Content> favorites;
    private List<ViewershipHistory> viewershipHistory;

    public User(String name, String email, String contactNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        this.favorites = new ArrayList<>();
        this.viewershipHistory = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Content> getFavorites() {
        return favorites;
    }

    public List<ViewershipHistory> getViewershipHistory() {
        return viewershipHistory;
    }

    // Other methods
    public void addToFavorites(Content content) {
        favorites.add(content);
    }

    public void addViewershipHistory(ViewershipHistory history) {
        viewershipHistory.add(history);
    }
}

class ContentProducer {
    private String name;
    private String email;
    private String contactNumber;
    private String username;
    private String password;
    private boolean accountApproved;

    public ContentProducer(String name, String email, String contactNumber, String username, String password) {
        this.name = name;
        this.email = email;
        this.contactNumber = contactNumber;
        this.username = username;
        this.password = password;
        this.accountApproved = false;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAccountApproved() {
        return accountApproved;
    }

    public void setAccountApproved(boolean accountApproved) {
        this.accountApproved = accountApproved;
    }
}

class Content {
    private String title;
    private String description;
    private String category;
    private String videoUrl;
    private List<Review> reviews;
    
    
 private boolean approved; //
    
    public boolean isApproved() {
        return approved;
    }
    
    public void setApproved(boolean approved) {
        this.approved = approved;
    }
    
    
    

    public Content(String title, String description, String category, String videoUrl) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.videoUrl = videoUrl;
        this.reviews = new ArrayList<>();
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    // Other methods
    public void addReview(Review review) {
        reviews.add(review);
    }

    public int getViewershipCount() {
        // Placeholder: Implement logic to calculate viewership count
        return 0;
    }

    public double getAverageRating() {
        // Placeholder: Implement logic to calculate average rating
        return 0.0;
    }
}

class Review {
    private User user;
    private int rating;
    private String comment;

    public Review(User user, int rating, String comment) {
        this.user = user;
        this.rating = rating;
        this.comment = comment;
    }

    // Getters
    public User getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}

class ViewershipHistory {
    private User user;
    private Content content;
    private Date timestamp;

    public ViewershipHistory(User user, Content content) {
        this.user = user;
        this.content = content;
        this.timestamp = new Date();
    }

    // Getters
    public User getUser() {
        return user;
    }

    public Content getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }
}

class Administrator {
    private final String username = "admin";
    private final String password = "admin";

    public boolean login(String enteredUsername, String enteredPassword) {
        return username.equals(enteredUsername) && password.equals(enteredPassword);
    }

    public void manageContentProducerAccounts(List<ContentProducer> contentProducers) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. Approve Content Producer Account");
        System.out.println("2. Reject Content Producer Account");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                System.out.println("Enter the username of the account to approve:");
                String usernameToApprove = scanner.next();
                approveContentProducer(contentProducers, usernameToApprove);
                break;

            case 2:
                System.out.println("Enter the username of the account to reject:");
                String usernameToReject = scanner.next();
                rejectContentProducer(contentProducers, usernameToReject);
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    private void approveContentProducer(List<ContentProducer> contentProducers, String username) {
        // Implement logic to approve a content producer account
        for (ContentProducer producer : contentProducers) {
            if (producer.getUsername().equals(username)) {
                producer.setAccountApproved(true);
                System.out.println("Account approved for " + producer.getName());
                return;
            }
        }
        System.out.println("Content producer not found.");
    }

    private void rejectContentProducer(List<ContentProducer> contentProducers, String username) {
        // Implement logic to reject a content producer account
        for (ContentProducer producer : contentProducers) {
            if (producer.getUsername().equals(username)) {
                producer.setAccountApproved(false);
                System.out.println("Account rejected for " + producer.getName());
                return;
            }
        }
        System.out.println("Content producer not found.");
    }

    public List<ViewershipHistory> getViewershipHistory(User user) {
        List<ViewershipHistory> userHistory = new ArrayList<>();
        for (ViewershipHistory history : user.getViewershipHistory()) {
            userHistory.add(history);
        }
        return userHistory;
    }

    public void processAndDisplayViewershipHistory(User user) {
        List<ViewershipHistory> userHistory = getViewershipHistory(user);
        for (ViewershipHistory history : userHistory) {
            System.out.println("User: " + history.getUser().getName());
            System.out.println("Content: " + history.getContent().getTitle());
            System.out.println("Timestamp: " + history.getTimestamp());
            System.out.println();
        }
    }

    public void performContentAnalytics(List<Content> contentList) {
        for (Content content : contentList) {
            System.out.println("Content: " + content.getTitle());

            int viewershipCount = content.getViewershipCount();
            System.out.println("Viewership Count: " + viewershipCount);

            double averageRating = content.getAverageRating();
            System.out.println("Average Rating: " + averageRating);

            if (viewershipCount > 1000) {
                System.out.println("This content is popular!");
            }

            System.out.println();
        }
    }

    public void generateReports(List<User> users, List<ContentProducer> contentProducers) {
        // Implement logic to generate various reports (e.g., top content, user activity)
        // Placeholder: Implement report generation logic
    }

    public void manageContent(List<Content> contentList) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select an option:");
        System.out.println("1. Add Content");
        System.out.println("2. Update Content");
        System.out.println("3. Remove Content");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                addContent(contentList);
                break;

            case 2:
                updateContent(contentList);
                break;

            case 3:
                removeContent(contentList);
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    private void addContent(List<Content> contentList) {
        // Placeholder: Implement logic to add new content
    	 Scanner scanner = new Scanner(System.in);
    	    
    	    System.out.println("Enter the title of the new content:");
    	    String title = scanner.nextLine();
    	    
    	    System.out.println("Enter the description of the new content:");
    	    String description = scanner.nextLine();
    	    
    	    System.out.println("Enter the category of the new content:");
    	    String category = scanner.nextLine();
    	    
    	    System.out.println("Enter the video URL of the new content:");
    	    String videoUrl = scanner.nextLine();
    	    
    	    Content newContent = new Content(title, description, category, videoUrl);
    	    contentList.add(newContent);
    	    
    	    System.out.println("New content added successfully!");
    }

    private void updateContent(List<Content> contentList) {
        // Placeholder: Implement logic to update existing content
    	
    	  Scanner scanner = new Scanner(System.in);
    	    
    	    System.out.println("Enter the title of the content to update:");
    	    String titleToUpdate = scanner.nextLine();
    	    
    	    Content contentToUpdate = findContentByTitle(contentList, titleToUpdate);
    	    
    	    if (contentToUpdate == null) {
    	        System.out.println("Content not found.");
    	        return;
    	    }
    	    
    	    System.out.println("Enter the new title of the content:");
    	    String newTitle = scanner.nextLine();
    	    
    	    System.out.println("Enter the new description of the content:");
    	    String newDescription = scanner.nextLine();
    	    
    	    System.out.println("Enter the new category of the content:");
    	    String newCategory = scanner.nextLine();
    	    
    	    System.out.println("Enter the new video URL of the content:");
    	    String newVideoUrl = scanner.nextLine();
    	    
    	    contentToUpdate.setTitle(newTitle);
    	    contentToUpdate.setDescription(newDescription);
    	    contentToUpdate.setCategory(newCategory);
    	    contentToUpdate.setVideoUrl(newVideoUrl);
    	    
    	    System.out.println("Content updated successfully!");
    	
    	
    }
    
    private Content findContentByTitle(List<Content> contentList, String title) {
        for (Content content : contentList) {
            if (content.getTitle().equalsIgnoreCase(title)) {
                return content;
            }
        }
        return null;
    }
    
    

    private void removeContent(List<Content> contentList) {
        // Placeholder: Implement logic to remove content
    	
    	Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the title of the content to remove:");
        String titleToRemove = scanner.nextLine();
        
        Content contentToRemove = findContentByTitle(contentList, titleToRemove);
        
        if (contentToRemove == null) {
            System.out.println("Content not found.");
            return;
        }
        
        contentList.remove(contentToRemove);
        
        System.out.println("Content removed successfully!");
    	
    	
    	
    	
    	
    	
    }
    
   

    public void trackUserActivity(List<User> users) {
        // Implement logic to track user interactions and behavior
        // Placeholder: Implement user activity tracking logic
    	
    	  Scanner scanner = new Scanner(System.in);
    	    
    	    System.out.println("Enter the username of the user to track:");
    	    String usernameToTrack = scanner.nextLine();
    	    
    	    User userToTrack = findUserByUsername(users, usernameToTrack);
    	    
    	    if (userToTrack == null) {
    	        System.out.println("User not found.");
    	        return;
    	    }
    	    
    	    System.out.println("Tracking user activity for: " + userToTrack.getUsername());
    	    
    	    while (true) {
    	        System.out.println("User actions:");
    	        System.out.println("1. Watched a content");
    	        System.out.println("2. Added content to favorites");
    	        System.out.println("3. Left a review");
    	        System.out.println("4. Exit tracking");
    	        
    	        int choice = scanner.nextInt();
    	        
    	        switch (choice) {
    	            case 1:
    	                System.out.println("Enter the title of the content watched:");
    	                String contentTitle = scanner.nextLine();
    	                // Implement logic to track content viewing
    	                System.out.println("User watched '" + contentTitle + "'");
    	                break;
    	                
    	            case 2:
    	                System.out.println("Enter the title of the content added to favorites:");
    	                String favoriteContentTitle = scanner.nextLine();
    	                // Implement logic to track adding content to favorites
    	                System.out.println("User added '" + favoriteContentTitle + "' to favorites");
    	                break;
    	                
    	            case 3:
    	                System.out.println("Enter the title of the content reviewed:");
    	                String reviewedContentTitle = scanner.nextLine();
    	                // Implement logic to track leaving a review
    	                System.out.println("User left a review on '" + reviewedContentTitle + "'");
    	                break;
    	                
    	            case 4:
    	                System.out.println("Exiting user activity tracking.");
    	                return;
    	                
    	            default:
    	                System.out.println("Invalid choice");
    	        }
    	    }
    	
    	
    	
    	
    	
    }
    
    private User findUserByUsername(List<User> users, String username) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username)) {
                return user;
            }
        }
        return null;
    }
    
    
    
    

    public void approveContent(Content content) {
        // Implement logic to approve content uploaded by producers
        // Placeholder: Implement content approval logic
    	
    	 if (!content.isApproved()) {
    	        content.setApproved(true);
    	        System.out.println("Content '" + content.getTitle() + "' has been approved.");
    	    } else {
    	        System.out.println("Content '" + content.getTitle() + "' is already approved.");
    	    }
    	
    	
    	
    }

    public void trackUsageStatistics(List<Content> contentList) {
        // Implement logic to track content viewership and usage patterns
        // Placeholder: Implement usage statistics tracking logic
    	
    	
    	 System.out.println("Tracking content usage statistics...");

    	    for (Content content : contentList) {
    	        int viewershipCount = content.getViewershipCount();
    	        double averageRating = content.getAverageRating();
    	        
    	        System.out.println("Content: " + content.getTitle());
    	        System.out.println("Viewership Count: " + viewershipCount);
    	        System.out.println("Average Rating: " + averageRating);
    	        
    	        // Add more usage statistics tracking logic based on your project requirements
    	        
    	        System.out.println(); // Empty line for separation
    	    }
    	    
    	    System.out.println("Content usage statistics tracking completed.");
    	
    	
    }
}

public class StreamMasterApp {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        List<ContentProducer> contentProducers = new ArrayList<>();
        List<Content> contentList = new ArrayList<>();
        Administrator administrator = new Administrator();

        // Simulate user and content producer interactions
        User user1 = new User("John", "john@example.com", "1234567890", "john123", "password");
        ContentProducer producer1 = new ContentProducer("Producer1", "producer1@example.com", "1112223333", "producer1", "password");
        Content movie1 = new Content("Action Movie", "An exciting action-packed movie.", "Movie", "http://example.com/movie1.mp4");

        users.add(user1);
        contentProducers.add(producer1);
        contentList.add(movie1);

        // Simulate interactions

        // Check if admin is logged in
        boolean isAdminLoggedIn = administrator.login("admin", "admin");
        if (isAdminLoggedIn) {
            administrator.manageContentProducerAccounts(contentProducers);

            administrator.processAndDisplayViewershipHistory(user1);

            administrator.performContentAnalytics(contentList);
            administrator.generateReports(users, contentProducers);

            administrator.manageContent(contentList);
            administrator.trackUserActivity(users);

            Content contentToApprove = contentList.get(0);
            administrator.approveContent(contentToApprove);

            administrator.trackUsageStatistics(contentList);

            // Other admin methods
            // Implement content categorization, user engagement, etc.
        }
    }
}
