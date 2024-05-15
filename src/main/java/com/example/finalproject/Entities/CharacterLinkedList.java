package com.example.finalproject.Entities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CharacterLinkedList {
    private Node head;

    private static class Node {
        Character character;
        Node next;

        Node(Character character) {
            this.character = character;
            this.next = null;
        }
    }

    public void add(Character character) {
        Node newNode = new Node(character);
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
                        Character character = parseCharacter(lines);
                        add(character);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private Character parseCharacter(List<String> lines) {
        Character character = new Character();
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "name":
                        character.setNameC(value);
                        break;
                    case "level":
                        character.setLevelC(Integer.parseInt(value));
                        break;
                    case "ancestry":
                        character.setAncestryC(value);
                        break;
                    case "background":
                        character.setBackgroundC(value);
                        break;
                    case "characterClass":
                        character.setCharacterClassC(value);
                        break;
                    case "strength":
                        character.setStrengthC(Integer.parseInt(value));
                        break;
                    case "dexterity":
                        character.setDexterityC(Integer.parseInt(value));
                        break;
                    case "constitution":
                        character.setConstitutionC(Integer.parseInt(value));
                        break;
                    case "intelligence":
                        character.setIntelligenceC(Integer.parseInt(value));
                        break;
                    case "wisdom":
                        character.setWisdomC(Integer.parseInt(value));
                        break;
                    case "charisma":
                        character.setCharismaC(Integer.parseInt(value));
                        break;
                    case "alignment":
                        character.setAlignmentC(value);
                        break;
                    case "armorClass":
                        character.setArmorClassC(Integer.parseInt(value));
                        break;
                    case "hitPoints":
                        character.setHitPointsC(Integer.parseInt(value));
                        break;
                    case "perception":
                        character.setPerceptionC(Integer.parseInt(value));
                        break;
                    case "speed":
                        character.setSpeedC(Integer.parseInt(value));
                        break;
                    case "attack":
                        character.setAttackC(value);
                        break;
                    case "bio":
                        character.setBioC(value);
                        break;
                    case "imagelink":
                        character.setImagelinkC(value);
                        break;
                }
            }
        }
        return character;
    }

    public void quickSort() {
        head = quickSortRec(head, null);
    }

    private Node quickSortRec(Node start, Node end) {
        if (start == end || start == null || start.next == end) {
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
        Character pivot = start.character;

        while (start != null && start != end) {
            if (start.character.getNameC().compareTo(pivot.getNameC()) < 0) {
                pivot_prev = curr;
                Character temp = curr.character;
                curr.character = start.character;
                start.character = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        Character temp = curr.character;
        curr.character = pivot;
        start.character = temp;

        return pivot_prev;
    }

    public Character binarySearch(String name) {
        List<Character> characters = toList();
        int left = 0;
        int right = characters.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Character midCharacter = characters.get(mid);
            int cmp = midCharacter.getNameC().compareTo(name);

            if (cmp == 0) {
                return midCharacter;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    private List<Character> toList() {
        List<Character> characters = new ArrayList<>();
        Node current = head;
        while (current != null) {
            characters.add(current.character);
            current = current.next;
        }
        return characters;
    }
}

