#include <string.h>
#include <stdio.h>
#include <stdlib.h>

#define UPX_HEADER_LENGTH (sizeof(upx_header) / sizeof(*upx_header))

static char upx_bytes  []  = {0x55, 0x50, 0x58, 0x21};
static char upx_header [] = { 0x24, 0x49, 0x6e, 0x66, 0x6f, 0x3a, 0x20, 0x54,
                              0x68, 0x69, 0x73, 0x20, 0x66, 0x69, 0x6c, 0x65,
                              0x20, 0x69, 0x73, 0x20, 0x70, 0x61, 0x63, 0x6b,
                              0x65, 0x64, 0x20, 0x77, 0x69, 0x74, 0x68, 0x20,
                              0x74, 0x68, 0x65, 0x20, 0x55, 0x50, 0x58, 0x20,
                              0x65, 0x78, 0x65, 0x63, 0x75, 0x74, 0x61, 0x62,
                              0x6c, 0x65, 0x20, 0x70, 0x61, 0x63, 0x6b, 0x65,
                              0x72, 0x20, 0x68, 0x74, 0x74, 0x70, 0x3a, 0x2f,
                              0x2f, 0x75, 0x70, 0x78, 0x2e, 0x73, 0x66, 0x2e,
                              0x6e, 0x65, 0x74, 0x20, 0x24, 0x0a, 0x00, 0x24,
                              0x49, 0x64, 0x3a, 0x20, 0x55, 0x50, 0x58, 0x20,
                              0x33, 0x2e, 0x39, 0x35, 0x20, 0x43, 0x6f, 0x70,
                              0x79, 0x72, 0x69, 0x67, 0x68, 0x74, 0x20, 0x28,
                              0x43, 0x29, 0x20, 0x31, 0x39, 0x39, 0x36, 0x2d,
                              0x32, 0x30, 0x31, 0x38, 0x20, 0x74, 0x68, 0x65,
                              0x20, 0x55, 0x50, 0x58, 0x20, 0x54, 0x65, 0x61,
                              0x6d, 0x2e, 0x20, 0x41, 0x6c, 0x6c, 0x20, 0x52,
                              0x69, 0x67, 0x68, 0x74, 0x73, 0x20, 0x52, 0x65,
                              0x73, 0x65, 0x72, 0x76, 0x65, 0x64, 0x2e, 0x20,
                              0x24
                            };

static unsigned char *generate_sub_string(size_t size)
{
    size_t i;
    unsigned char *stream = malloc (size);
    if(!stream)
        return NULL;

    for (i = 0; i < size; i++)
    {
        stream[i] = rand ();
    }

    return stream;
}

/* Driver program to test above funtion */
int main(int argc, char * argv[])
{

    FILE * pFile;
    long lSize;
    unsigned char * buffer;
    size_t result;

    srand ((unsigned int) time (NULL));

    unsigned char* upx_sub  = generate_sub_string(sizeof(upx_bytes));
    if(upx_sub == NULL)
    {
        fputs ("File error",stderr);
        goto error_gen_sub_str;
    }
    unsigned char* header_sub = generate_sub_string(UPX_HEADER_LENGTH);
    if(header_sub == NULL)
    {
        fputs ("File error",stderr);
        goto error_gen_header_sub_str;
    }

    pFile = fopen ( argv[1] , "r+b" );
    if(pFile==NULL){
        fputs ("File error",stderr);
        goto error_fopen;
    }

    fseek (pFile , 0 , SEEK_END);
    lSize = ftell (pFile);
    rewind (pFile);

    buffer = (char*) malloc (sizeof(char)*lSize);
    if(buffer == NULL){
        fputs("Memory error",stderr);
        goto error_buffer;
    }

    result = fread (buffer,1,lSize,pFile);
    if(result != lSize){
        fputs("Reading error",stderr);
        goto error_fread;
    }

    for (int i=0; i<lSize; i++){
        if (memcmp(&buffer[i], upx_bytes, sizeof(upx_bytes)) == 0)
        {
            fseek(pFile, i, SEEK_SET);
            fwrite(upx_sub, sizeof(upx_sub), 1, pFile);
        }
        else if(memcmp(&buffer[i], upx_header, UPX_HEADER_LENGTH) == 0)
        {
            fseek(pFile, i, SEEK_SET);
            fwrite(header_sub, strlen(header_sub), 1, pFile);
        }
    }
    fflush(pFile);

    error_fread:
        free(buffer);
    error_buffer:
        fclose(pFile);
    error_fopen:
        free(header_sub);
    error_gen_header_sub_str:
        free(upx_sub);
    error_gen_sub_str:
        return 0;
}
