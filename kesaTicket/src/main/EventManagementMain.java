package main;

import java.util.ArrayList;
import java.util.Scanner;

import Event_is_a.Concert;
import Event_is_a.Conference;
import Event.Event;
import sys.EventManagementSystem;
import Event_is_a.SportsEvent;
import GUI.MainMenuFrame;
import User.User;

public class EventManagementMain {
    public static void main(String[] args) {
        EventManagementSystem system = new EventManagementSystem();
        system.createTestEvents();
        system.createTestUsers();

        MainMenuFrame mmf = new MainMenuFrame();
        mmf.setVisible(true);
    }
}