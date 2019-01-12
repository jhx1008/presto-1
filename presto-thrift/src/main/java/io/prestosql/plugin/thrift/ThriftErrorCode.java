/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.prestosql.plugin.thrift;

import com.facebook.presto.spi.ErrorCode;
import com.facebook.presto.spi.ErrorCodeSupplier;
import com.facebook.presto.spi.ErrorType;

import static com.facebook.presto.spi.ErrorType.EXTERNAL;

public enum ThriftErrorCode
        implements ErrorCodeSupplier
{
    THRIFT_SERVICE_CONNECTION_ERROR(1, EXTERNAL),
    THRIFT_SERVICE_INVALID_RESPONSE(2, EXTERNAL),
    THRIFT_SERVICE_GENERIC_REMOTE_ERROR(3, EXTERNAL),
    THRIFT_SERVICE_NO_AVAILABLE_HOSTS(4, EXTERNAL);

    private final ErrorCode errorCode;

    ThriftErrorCode(int code, ErrorType type)
    {
        errorCode = new ErrorCode(code + 0x0105, name(), type);
    }

    @Override
    public ErrorCode toErrorCode()
    {
        return errorCode;
    }
}