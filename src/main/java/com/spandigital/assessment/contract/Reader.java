package com.spandigital.assessment.contract;

import java.io.IOException;
import java.io.InputStream;

public interface Reader {
    Iterable<String> read(InputStream inputStream) throws IOException;
}
