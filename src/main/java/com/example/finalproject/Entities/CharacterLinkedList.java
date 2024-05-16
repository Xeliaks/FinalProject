package com.example.finalproject.Entities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CharacterLinkedList {
    private Node head;

    public Iterable<? extends CharacterC> getCharacters() {
        List<CharacterC> characters = new ArrayList<>();
        Node current = head;
        while (current != null) {
            characters.add(current.characterC);
            current = current.next;
        }
        return characters;
    }

    private static class Node {
        CharacterC characterC;
        Node next;

        Node(CharacterC characterC) {
            this.characterC = characterC;
            this.next = null;
        }
    }

    public void add(CharacterC characterC) {
        Node newNode = new Node(characterC);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void loadFromFolder(String folderPath) {
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try {
                        List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                        CharacterC characterC = parseCharacter(lines);
                        add(characterC);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private CharacterC parseCharacter(List<String> lines) {
        CharacterC characterC = new CharacterC();
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length < 2) continue;
            String key = parts[0].trim();
            String value = parts[1].trim();
            switch (key) {
                case "Name": characterC.setNameC(value); break;
                case "Level": characterC.setLevelC(Integer.parseInt(value)); break;
                case "Ancestry": characterC.setAncestryC(value); break;
                case "Background": characterC.setBackgroundC(value); break;
                case "Class": characterC.setCharacterClassC(value); break;
                case "Strength": characterC.setStrengthC(Integer.parseInt(value)); break;
                case "Dexterity": characterC.setDexterityC(Integer.parseInt(value)); break;
                case "Constitution": characterC.setConstitutionC(Integer.parseInt(value)); break;
                case "Intelligence": characterC.setIntelligenceC(Integer.parseInt(value)); break;
                case "Wisdom": characterC.setWisdomC(Integer.parseInt(value)); break;
                case "Charisma": characterC.setCharismaC(Integer.parseInt(value)); break;
                case "Alignment": characterC.setAlignmentC(value); break;
                case "Armor Class": characterC.setArmorClassC(Integer.parseInt(value)); break;
                case "Hit Points": characterC.setHitPointsC(Integer.parseInt(value)); break;
                case "Perception": characterC.setPerceptionC(Integer.parseInt(value)); break;
                case "Speed": characterC.setSpeedC(Integer.parseInt(value)); break;
                case "Attack": characterC.setAttackC(value); break;
                case "Bio": characterC.setBioC(value); break;
                case "Image Link": characterC.setImageLinkC(value); break;
            }
        }
        return characterC;
    }

    public void quickSort() {
        head = quickSortRec(head, getTail(head));
    }

    private Node getTail(Node cur) {
        while (cur != null && cur.next != null) {
            cur = cur.next;
        }
        return cur;
    }

    private Node quickSortRec(Node start, Node end) {
        if (start == end) {
            return start;
        }

        Node pivot_prev = partition(start, end);
        quickSortRec(start, pivot_prev);

        if (pivot_prev != null && pivot_prev == start) {
            quickSortRec(pivot_prev.next, end);
        } else if (pivot_prev != null && pivot_prev.next != null) {
            quickSortRec(pivot_prev.next.next, end);
        }

        return start;
    }

    private Node partition(Node start, Node end) {
        if (start == end || start == null || start.next == end) {
            return start;
        }

        Node pivot_prev = start;
        Node curr = start;
        CharacterC pivot = start.characterC;

        while (start != end) {
            if (start.characterC.getNameC().compareTo(pivot.getNameC()) < 0) {
                pivot_prev = curr;
                CharacterC temp = curr.characterC;
                curr.characterC = start.characterC;
                start.characterC = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        CharacterC temp = curr.characterC;
        curr.characterC = pivot;
        pivot = temp;

        return pivot_prev;
    }

    public CharacterC binarySearch(String name) {
        List<CharacterC> characterCS = toList();
        int left = 0;
        int right = characterCS.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            CharacterC midCharacterC = characterCS.get(mid);
            int cmp = midCharacterC.getNameC().compareTo(name);

            if (cmp == 0) {
                return midCharacterC;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    private List<CharacterC> toList() {
        List<CharacterC> characterCS = new ArrayList<>();
        Node current = head;
        while (current != null) {
            characterCS.add(current.characterC);
            current = current.next;
        }
        return characterCS;
    }
}


