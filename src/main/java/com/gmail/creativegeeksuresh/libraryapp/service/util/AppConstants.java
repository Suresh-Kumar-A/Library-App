package com.gmail.creativegeeksuresh.libraryapp.service.util;

import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.gmail.creativegeeksuresh.libraryapp.dto.BookDto;

public class AppConstants {

        public static final String ADMIN_ROLE_STRING = "ADMIN";

        public static final String USER_ROLE_STRING = "USER";

        public static final String ROLE_STRING = "ROLE_";

        public static final Set<String> ROLE_SET = Collections
                        .unmodifiableSet(new HashSet<>(Arrays.asList(ADMIN_ROLE_STRING, USER_ROLE_STRING)));

        public static final List<BookDto> DEFAULT_DATA_LIST;

        static {
                DEFAULT_DATA_LIST = new ArrayList<>();
                BookDto bookDto1 = new BookDto();
                bookDto1.setTitle("Wings of Fire");
                bookDto1.setAuthor("Dr. APJ Kalam");
                bookDto1.setDescription("Good book for youngsters");
                bookDto1.setAvailable(Boolean.TRUE);
                bookDto1.setPublishedYear(Year.parse("1999"));

                BookDto bookDto2 = new BookDto();
                bookDto2.setTitle("Steve Jobs");
                bookDto2.setAuthor("Steve Jobs");
                bookDto2.setDescription("Steve Jobs is the authorized self-titled biography of Steve Jobs.");
                bookDto2.setAvailable(Boolean.TRUE);
                bookDto2.setPublishedYear(Year.parse("2015"));

                BookDto bookDto3 = new BookDto();
                bookDto3.setTitle("The Story of My Experiments with Truth");
                bookDto3.setAuthor("Mohandas Karamchand Gandhi");
                bookDto3.setDescription(
                                "The Story of My Experiments with Truth is the autobiography of Mohandas K. Gandhi");
                bookDto3.setAvailable(Boolean.FALSE);
                bookDto3.setPublishedYear(Year.parse("1948"));

                BookDto bookDto4 = new BookDto();
                bookDto4.setTitle("A Promised Land");
                bookDto4.setAuthor("Barack Obama");
                bookDto4.setDescription(
                                "A Promised Land is a memoir by Barack Obama, the 44th President of the United States from 2009 to 2017");
                bookDto4.setAvailable(Boolean.FALSE);
                bookDto4.setPublishedYear(Year.parse("2009"));

                BookDto bookDto5 = new BookDto();
                bookDto5.setTitle("I Am Malala");
                bookDto5.setAuthor("Malala Yousafzai");
                bookDto5.setDescription("The Story of the Girl Who Stood Up for Education and was Shot by the Taliban");
                bookDto5.setAvailable(Boolean.TRUE);
                bookDto5.setPublishedYear(Year.parse("2013"));

                DEFAULT_DATA_LIST.add(bookDto1);
                DEFAULT_DATA_LIST.add(bookDto2);
                DEFAULT_DATA_LIST.add(bookDto3);
                DEFAULT_DATA_LIST.add(bookDto4);
                DEFAULT_DATA_LIST.add(bookDto5);
        }
}
