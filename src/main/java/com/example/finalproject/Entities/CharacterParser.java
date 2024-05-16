package com.example.finalproject.Entities;

import java.util.List;

public class CharacterParser {
    public CharacterC parseCharacter(List<String> lines) throws Exception {
        CharacterC characterC = new CharacterC();
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "name":
                        characterC.setNameC(value);
                        break;
                    case "level":
                        characterC.setLevelC(Integer.parseInt(value));
                        break;
                    case "ancestry":
                        characterC.setAncestryC(value);
                        break;
                    case "background":
                        characterC.setBackgroundC(value);
                        break;
                    case "class":
                        characterC.setClassC(value);
                        break;
                    case "strength":
                        characterC.setStrengthC(Integer.parseInt(value));
                        break;
                    case "dexterity":
                        characterC.setDexterityC(Integer.parseInt(value));
                        break;
                    case "constitution":
                        characterC.setConstitutionC(Integer.parseInt(value));
                        break;
                    case "intelligence":
                        characterC.setIntelligenceC(Integer.parseInt(value));
                        break;
                    case "wisdom":
                        characterC.setWisdomC(Integer.parseInt(value));
                        break;
                    case "charisma":
                        characterC.setCharismaC(Integer.parseInt(value));
                        break;
                    case "alignment":
                        characterC.setAlignmentC(value);
                        break;
                    case "ac":
                        characterC.setAcC(Integer.parseInt(value));
                        break;
                    case "hp":
                        characterC.setHpC(Integer.parseInt(value));
                        break;
                    case "speed":
                        characterC.setSpeedC(Integer.parseInt(value));
                        break;
                    case "perception":
                        characterC.setPerceptionC(Integer.parseInt(value));
                        break;
                    case "attack":
                        characterC.setAttackC(value);
                        break;
                    case "bio":
                        characterC.setBioC(value);
                        break;
                    case "imageLink":
                        characterC.setImageLinkC(value);
                        break;
                    default:
                        throw new Exception("Invalid key in character file");
                }
            } else {
                throw new Exception("Invalid line format in character file");
            }
        }
        return characterC;
    }
}
