package com.example.max.chucknorristest.data.client

import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class EmptyConverterFactory: Converter.Factory() {

    override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>,
                                       retrofit: Retrofit): Converter<ResponseBody, *> {
        val delegate = retrofit.nextResponseBodyConverter<Any>(this, type, annotations)
        return Converter<ResponseBody, Any> { body ->
            if (body.contentLength() > 0L || body.contentLength() == -1L) {
                delegate.convert(body)
            } else {
                Any()
            }
        }
    }

}