#include <stdio.h>
#include <stdlib.h>
#include <threads.h>
#include <stdatomic.h>

#ifndef NUM_THREADS
#define NUM_THREADS 4
#endif

thread_local int counter = 0;

enum {MAX_ITER = 10000};

void *incrementCounter(void *thr_id) {
    long tid;
    tid = (long)thr_id;
    printf("thread %ld started incrementing ID - %lu\n", tid, thrd_current());

    for (int i = 0; i < MAX_ITER; ++i) {
        counter += 1;
    }

    return (void *)counter;
}

int main(int argc, char const *argv[]) {
    thrd_t threads[NUM_THREADS];
    int rc, sum = 0;

    for (int i = 0; i < NUM_THREADS; ++i) {
        rc = thrd_create(&threads[i], (thrd_start_t) incrementCounter, (void *)i);
        if (rc == thrd_error) {
            printf("ERORR; thrd_create() call failed\n");
            exit(EXIT_FAILURE);
        }
    }

    int retval;
    for (int i = 0; i < NUM_THREADS; ++i) {
        thrd_join(threads[i], &retval);
        sum += retval;
    }
    printf("count = %d\n", sum);

    thrd_exit(EXIT_SUCCESS);
}