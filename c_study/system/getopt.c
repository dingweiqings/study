#include <getopt.h>
int main(int argc, char *argv[])
{
    int opt;
    while ((opt = getopt(argc, argv, "t:l:p:")) != -1)
    {
        switch (opt)
        {
        case 't':
        {
            puts("This is t");
            puts(optarg);
            break;
        }
        case 'l':
        {
            puts("This is l ");
            puts(optarg);
            break;
        }
        case 'p':
        {
            puts("This is p");
             puts(optarg);
            break;
        }
        default:
            break;
        }
    }
}