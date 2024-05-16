package com.example.finalproject.Entities;


import java.util.List;

public class MonsterParser {
    public Monster parseMonster(List<String> lines) throws Exception {
        Monster monster = new Monster();
        for (String line : lines) {
            String[] parts = line.split(":");
            if (parts.length == 2) {
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "name":
                        monster.setNameM(value);
                        break;
                    case "level":
                        monster.setLevelM(Integer.parseInt(value));
                        break;
                    case "strength":
                        monster.setStrengthM(Integer.parseInt(value));
                        break;
                    case "dexterity":
                        monster.setDexterityM(Integer.parseInt(value));
                        break;
                    case "constitution":
                        monster.setConstitutionM(Integer.parseInt(value));
                        break;
                    case "intelligence":
                        monster.setIntelligenceM(Integer.parseInt(value));
                        break;
                    case "wisdom":
                        monster.setWisdomM(Integer.parseInt(value));
                        break;
                    case "charisma":
                        monster.setCharismaM(Integer.parseInt(value));
                        break;
                    case "alignment":
                        monster.setAlignmentM(value);
                        break;
                    case "armorClass":
                        monster.setArmorClassM(Integer.parseInt(value));
                        break;
                    case "hitPoints":
                        monster.setHitPointsM(Integer.parseInt(value));
                        break;
                    case "perception":
                        monster.setPerceptionM(Integer.parseInt(value));
                        break;
                    case "speed":
                        monster.setSpeedM(Integer.parseInt(value));
                        break;
                    case "attack":
                        monster.setAttackM(value);
                        break;
                    case "bio":
                        monster.setBioM(value);
                        break;
                    case "imageLink":
                        monster.setImageLinkM(value);
                        break;
                    default:
                        throw new Exception("Invalid key in monster file");
                }
            } else {
                throw new Exception("Invalid line format in monster file");
            }
        }
        return monster;
    }
}
