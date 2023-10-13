package org.softuni.exam.structures;

import org.softuni.exam.entities.User;
import org.softuni.exam.entities.Video;

import java.util.*;
import java.util.stream.Collectors;

public class ViTubeRepositoryImpl implements ViTubeRepository {

    Map<String, User> usersById = new LinkedHashMap<>();
    Map<String, Video> videosById = new LinkedHashMap<>();
    Map<String, List<Video>> videosWatchedByUsers = new HashMap<>();
    Map<String, List<Video>> videosLikedByUsers = new HashMap<>();
    Map<String, List<Video>> videosDislikedByUsers = new HashMap<>();
    Set<User> passiveUsers = new LinkedHashSet<>();

    @Override
    public void registerUser(User user) {
        usersById.put(user.getId(), user);
        passiveUsers.add(user);

        videosWatchedByUsers.put(user.getId(), new ArrayList<>());
        videosLikedByUsers.put(user.getId(), new ArrayList<>());
        videosDislikedByUsers.put(user.getId(), new ArrayList<>());
    }

    @Override
    public void postVideo(Video video) {
        videosById.put(video.getId(), video);
    }

    @Override
    public boolean contains(User user) {
        return usersById.get(user.getId()) != null;
    }

    @Override
    public boolean contains(Video video) {
        return videosById.get(video.getId()) != null;
    }

    @Override
    public Iterable<Video> getVideos() {
        return videosById.values();
    }

    @Override
    public void watchVideo(User user, Video video) throws IllegalArgumentException {
        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }

        videosWatchedByUsers.get(user.getId()).add(video);
        int views = videosById.get(video.getId()).getViews();

        videosById.get(video.getId()).setViews(views + 1);

        passiveUsers.remove(user);
    }

    @Override
    public void likeVideo(User user, Video video) throws IllegalArgumentException {
        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }

        Video currentVideo = videosById.get(video.getId());
        int likes = currentVideo.getLikes();
        int dislikes = currentVideo.getDislikes();

        if (dislikes > 0) {
            currentVideo.setDislikes(dislikes - 1);
        }
        currentVideo.setLikes(likes + 1);

        videosLikedByUsers.get(video.getId()).add(video);
        passiveUsers.remove(user);
    }

    @Override
    public void dislikeVideo(User user, Video video) throws IllegalArgumentException {
        if (!contains(user) || !contains(video)) {
            throw new IllegalArgumentException();
        }

        Video currentVideo = videosById.get(video.getId());
        int likes = currentVideo.getLikes();
        int dislikes = currentVideo.getDislikes();

        currentVideo.setLikes(likes - 1);
        currentVideo.setDislikes(dislikes + 1);

        videosDislikedByUsers.get(video.getId()).add(video);
        passiveUsers.remove(user);
    }

    @Override
    public Iterable<User> getPassiveUsers() {
        return passiveUsers;
    }

    @Override
    public Iterable<Video> getVideosOrderedByViewsThenByLikesThenByDislikes() {
        return videosById.values().stream()
                .sorted(Comparator.comparingInt(Video::getViews).reversed()
                        .thenComparing(Video::getLikes).reversed()
                        .thenComparing(Video::getDislikes))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<User> getUsersByActivityThenByName() {
        return usersById.values().stream()
                .sorted(Comparator.comparing((User u) -> videosWatchedByUsers.get(u.getId()).size()).reversed()
                        .thenComparing(
                                user -> videosLikedByUsers.get(user.getId()).size()
                                        + videosDislikedByUsers.get(user.getId()).size())
                        .reversed()
                        .thenComparing(User::getUsername))
                .collect(Collectors.toList());
    }
}
