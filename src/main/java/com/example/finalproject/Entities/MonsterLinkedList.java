package com.example.finalproject.Entities;


import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MonsterLinkedList {
    private Node head;
    private List<Monster> monsters = new ArrayList<>();

    public List<Monster> getMonsters() {
        return monsters;
    }

    public Iterable<? extends Monster> getCharacters() {
        List<Monster> characters = new ArrayList<>();
        Node current = head;
        while (current != null) {
            characters.add(current.monster);
            current = current.next;
        }
        return monsters;
    }

    private static class Node {
        Monster monster;
        Node next;

        Node(Monster monster) {
            this.monster = monster;
            this.next = null;
        }
    }


    public void add(Monster monster) {
        Node newNode = new Node(monster);
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
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    MonsterParser parser = new MonsterParser();
                    try {
                        List<String> lines = Files.readAllLines(file.toPath());
                        Monster monster = parser.parseMonster(lines);
                        add(monster);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    private Monster parseMonster(List<String> lines) {
        Monster monster = new Monster();
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "nameM":
                        monster.setNameM(value);
                        break;
                    case "levelM":
                        monster.setLevelM(Integer.parseInt(value));
                        break;
                    case "strengthM":
                        monster.setStrengthM(Integer.parseInt(value));
                        break;
                    case "dexterityM":
                        monster.setDexterityM(Integer.parseInt(value));
                        break;
                    case "constitutionM":
                        monster.setConstitutionM(Integer.parseInt(value));
                        break;
                    case "intelligenceM":
                        monster.setIntelligenceM(Integer.parseInt(value));
                        break;
                    case "wisdomM":
                        monster.setWisdomM(Integer.parseInt(value));
                        break;
                    case "charismaM":
                        monster.setCharismaM(Integer.parseInt(value));
                        break;
                    case "alignmentM":
                        monster.setAlignmentM(value);
                        break;
                    case "armorClassM":
                        monster.setArmorClassM(Integer.parseInt(value));
                        break;
                    case "hitPointsM":
                        monster.setHitPointsM(Integer.parseInt(value));
                        break;
                    case "perceptionM":
                        monster.setPerceptionM(Integer.parseInt(value));
                        break;
                    case "speedM":
                        monster.setSpeedM(Integer.parseInt(value));
                        break;
                    case "attackM":
                        monster.setAttackM(value);
                        break;
                    case "bioM":
                        monster.setBioM(value);
                        break;
                    case "imageLinkM":
                        monster.setImageLinkM(value);
                        break;
                }
            }
        }
        return monster;
    }
    private Node getTail(Node node) {
        while (node != null && node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void quickSort() {
        head = quickSortRec(head, getTail(head));
    }

    private Node quickSortRec(Node start, Node end) {
        if (start == end || start == null || start.next == end) {
            return start;
        }

        Node pivot_prev = partition(start, end);

        if (pivot_prev != null && pivot_prev != start) {
            Node temp = start;
            while (temp.next != pivot_prev) {
                temp = temp.next;
            }
            temp.next = null;

            start = quickSortRec(start, temp);

            temp = getTail(start);
            temp.next = pivot_prev;
        }

        pivot_prev.next = quickSortRec(pivot_prev.next, end);

        return start;
    }

    private Node partition(Node start, Node end) {
        if (start == end || start == null || start.next == end) {
            return start;
        }

        Node pivot_prev = start;
        Node curr = start;
        Monster pivot = end.monster;

        while (start != end) {
            if (start.monster.getNameM().compareTo(pivot.getNameM()) < 0) {
                pivot_prev = curr;
                Monster temp = curr.monster;
                curr.monster = start.monster;
                start.monster = temp;
                curr = curr.next;
            }
            start = start.next;
        }

        Monster temp = curr.monster;
        curr.monster = pivot;
        end.monster = temp;

        return pivot_prev;
    }

    public Monster binarySearch(String name) {
        List<Monster> monsters = toList();
        int left = 0;
        int right = monsters.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Monster midMonster = monsters.get(mid);
            int cmp = midMonster.getNameM().compareTo(name);

            if (cmp == 0) {
                return midMonster;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }

    private List<Monster> toList() {
        List<Monster> monsters = new ArrayList<>();
        Node current = head;
        while (current != null) {
            monsters.add(current.monster);
            current = current.next;
        }
        return monsters;
    }

}

