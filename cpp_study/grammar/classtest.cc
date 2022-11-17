#include<iostream>
#include<math.h>
using namespace std;
class A{
    private:
    int a;
    public:
    void setValue(int value){
        a=value;
    }
    int getValue(){
        return a;
    }
};
int divide( double num[], int nlen,
            double den[], int dlen,
            double quotient[], int *qlen )
{
    int n, d, q;
    // The lengths are one more than the last index; decrement them
    // here so the call is less confusing
    nlen--;
    dlen--;
    q = 0;
    // when n > dlen, the result is no longer a polynomial
    // (e.g. trying to divide x by x^2
    for ( n = nlen; n >= dlen; n-- )
    {
      // First, divide the nth element of numerator with the last element
      // of the denominator
      quotient[ n - dlen ] = num[ n ] / den[ dlen ];
      q++;
      // Now, multiply each element of the denominator by each
      // corresponding element of the numerator and subtract the
      // result
      for ( d = dlen; d >= 0; d-- )
      {
        num[ n - ( dlen - d ) ] -= den[ d ] * quotient[ n - dlen ];
      }
    }
    *qlen = q;

    return ( nlen - *qlen + 1 );
}
unsigned long int compute_crc_my( unsigned long input,
                               int len,
                               unsigned long divisor )
{
  while ( len-- )
  {
    if(input & 0x80000000 ){
      input = input ^ divisor;
      input=  input <<1;
    }else{
     input= input <<1;
    }
  }

  return input;
}
unsigned long int compute_crc_byte( unsigned char *input,
                               int len,
                               unsigned long divisor )
{
  int i, k;
  unsigned long crc = 0xFFFFFFFF;

  for ( i = 0; i < len; i++ )
  {
    crc ^= ( input[ i ] );
    for ( k = 8; k; k-- )
    {
      crc = crc & 1 ? ( crc >> 1 ) ^ divisor : crc >> 1;
    }
  }

  return crc ^ 0xFFFFFFFF;
}
unsigned long int compute_crc( unsigned long input,
                               int len,
                               unsigned long divisor )
{
  while ( len-- )
  {
    input = ( input & 0x80000000 ) ? divisor ^ ( input << 1 ) : ( input << 1 );
  }

  return input;
}
int main(){
  unsigned long int crc32_divisor = 0x04C11DB7;
  unsigned long int input = 0x8242C200; // ABC; backwards & left aligned

  printf( "%lx\n", compute_crc( input, 24, crc32_divisor ));
      printf( "%lx\n", compute_crc_byte( (unsigned char *)"0x8242C200", 24, crc32_divisor ));
    printf( "%lx\n", compute_crc_my( input, 24, crc32_divisor ));
  // 5A5B433Al;

}

