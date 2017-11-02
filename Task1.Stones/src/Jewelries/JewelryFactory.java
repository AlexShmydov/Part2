package Jewelries;

import Stones.Stone;
import Stones.StoneFactory;

public class JewelryFactory {
    public static BaseJewelry createJewelry(String name, int countOfStonesInJewelry, int minCountOfJewels) {
        BaseJewelry jewelry = new BaseJewelry(name);
        for (int i = 0; i < countOfStonesInJewelry; i++) {
            Stone stone = StoneFactory.createStoneWithDefaultParameters();
            if (!stone.getIsJewelling() && minCountOfJewels != 0 && minCountOfJewels + i >= countOfStonesInJewelry) {
                i--;
            } else {
                jewelry.addStone(stone);
            }

            if (stone.getIsJewelling() && minCountOfJewels > 0) {
                minCountOfJewels--;
            }
        }
        return jewelry;
    }
}
