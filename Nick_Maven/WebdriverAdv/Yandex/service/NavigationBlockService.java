package Nick_Maven.WebdriverAdv.Yandex.service;

import Nick_Maven.WebdriverAdv.Yandex.pages.NavigationBlockPage;

import java.util.ArrayList;

public class NavigationBlockService {
    private static final String EXPECTED_LAST_FILES_TAG = "Последние файлы";
    private static final String EXPECTED_FILES_TAG = "Файлы";
    private static final String EXPECTED_FOTO_TAG = "Все фотографии";
    private static final String EXPECTED_ALBUM_TAG = "Альбомы";
    private static final String EXPECTED_SHARED_TAG = "Публичные ссылки";
    private static final String EXPECTED_HISTORY_TAG = "История";
    private static final String EXPECTED_ARCHIVE_TAG = "Архив";
    private static final String EXPECTED_GARBAGE_TAG = "Корзина";

    public static boolean titlesComparisonInNavBlock() {
        boolean navigationBlockTitlesAsExpected;
        ArrayList<String> expectedTitlesOfBlock = new ArrayList<>();
        expectedTitlesOfBlock.add(EXPECTED_LAST_FILES_TAG);
        expectedTitlesOfBlock.add(EXPECTED_FILES_TAG);
        expectedTitlesOfBlock.add(EXPECTED_FOTO_TAG);
        expectedTitlesOfBlock.add(EXPECTED_ALBUM_TAG);
        expectedTitlesOfBlock.add(EXPECTED_SHARED_TAG);
        expectedTitlesOfBlock.add(EXPECTED_HISTORY_TAG);
        expectedTitlesOfBlock.add(EXPECTED_ARCHIVE_TAG);
        expectedTitlesOfBlock.add(EXPECTED_GARBAGE_TAG);
        navigationBlockTitlesAsExpected = NavigationBlockPage.getRealTitlesOfBlock.equals(expectedTitlesOfBlock);
        System.out.println("All navigation titles are as expected: " + navigationBlockTitlesAsExpected);
        return navigationBlockTitlesAsExpected;
    }
}