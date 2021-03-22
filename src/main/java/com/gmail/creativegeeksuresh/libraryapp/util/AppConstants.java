package com.gmail.creativegeeksuresh.libraryapp.util;

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
                BookDto BookDto1 = new BookDto();
                BookDto1.setTitle("Wings of Fire");
                BookDto1.setAuthor("Dr. APJ Kalam");
                BookDto1.setDescription("Good BookDto for youngsters");
                BookDto1.setAvailable(Boolean.TRUE);
                BookDto1.setPublishedYear(Year.parse("1999"));

                BookDto BookDto2 = new BookDto();
                BookDto2.setTitle("Steve Jobs");
                BookDto2.setAuthor("Steve Jobs");
                BookDto2.setDescription("Steve Jobs is the authorized self-titled biography of Steve Jobs.");
                BookDto2.setAvailable(Boolean.TRUE);
                BookDto2.setPublishedYear(Year.parse("2015"));

                BookDto BookDto3 = new BookDto();
                BookDto3.setTitle("The Story of My Experiments with Truth");
                BookDto3.setAuthor("Mohandas Karamchand Gandhi");
                BookDto3.setDescription(
                                "The Story of My Experiments with Truth is the autobiography of Mohandas K. Gandhi");
                BookDto3.setAvailable(Boolean.FALSE);
                BookDto3.setPublishedYear(Year.parse("1948"));

                BookDto BookDto4 = new BookDto();
                BookDto4.setTitle("A Promised Land");
                BookDto4.setAuthor("Barack Obama");
                BookDto4.setDescription(
                                "A Promised Land is a memoir by Barack Obama, the 44th President of the United States from 2009 to 2017");
                BookDto4.setAvailable(Boolean.FALSE);
                BookDto4.setPublishedYear(Year.parse("2009"));

                BookDto BookDto5 = new BookDto();
                BookDto5.setTitle("I Am Malala");
                BookDto5.setAuthor("Malala Yousafzai");
                BookDto5.setDescription(
                                "The Story of the Girl Who Stood Up for Education and was Shot by the Taliban is an autobiographical BookDto by Malala Yousafzai");
                BookDto5.setAvailable(Boolean.TRUE);
                BookDto5.setPublishedYear(Year.parse("2013"));

                DEFAULT_DATA_LIST.add(BookDto1);
                DEFAULT_DATA_LIST.add(BookDto2);
                DEFAULT_DATA_LIST.add(BookDto3);
                DEFAULT_DATA_LIST.add(BookDto4);
                DEFAULT_DATA_LIST.add(BookDto5);
        }
}
