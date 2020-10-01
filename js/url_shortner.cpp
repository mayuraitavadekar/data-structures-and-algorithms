/**
 * URL shortener Base-62 encoder / decoder C++ Proof-of-Concept.
 *
 * Created as a resource for https://stackoverflow.com/a/742047/293064.
 *
 * How to compile:
 *
 *     g++ -o base64-url-shortener-poc base64-url-shortener-poc.cpp
 *
 * Usage:
 *
 *     ./base64-url-shortener-poc [ID]
 *
 * Example output:
 *
 *     Input ID: 99592
 *     ---
 *     Generated short URL: z4u
 *     ID decoded from URL: 99592
 *
 * @author Jay Taylor <outtatime@gmail.com>
 *
 * @date 2019-07-08
 *
 */

#include <iostream>
#include <algorithm>
#include <string>
#include <cstdlib>

using namespace std;

/**
 * id_to_short_url takes an input ID and produces a short URL suffix.
 *
 * Base-62 encodes the identifier.
 */
string id_to_short_url(unsigned int n) {
    // Mapping which defines the 62 possible output characters.
    char map[] = "abcdefghijklmnopqrstuvwxyzABCDEF"
                 "GHIJKLMNOPQRSTUVWXYZ0123456789";

    string short_url;

    // Convert given ID to a base-62 number.
    while (n) {
        // Append each character mapped by the remainder.
        short_url.push_back(map[n % 62]);
        n /= 62;
    }

    // Reverse the string to complete the base conversion.
    reverse(short_url.begin(), short_url.end());

    return short_url;
}

/**
 * short_url_to_id converts a short URL into the corresponding ID.
 *
 * Base-62 decodes the input string.
 */
unsigned int short_url_to_id(string short_url) {
    unsigned int id = 0;

    // Base decode conversion logic.
    for (int i = 0; i < short_url.length(); ++i) {
        if ('a' <= short_url[i] && short_url[i] <= 'z') {
            id = id * 62 + short_url[i] - 'a';
        }
        if ('A' <= short_url[i] && short_url[i] <= 'Z') {
            id = id * 62 + short_url[i] - 'A' + 26;
        }
        if ('0' <= short_url[i] && short_url[i] <= '9') {
            id = id * 62 + short_url[i] - '0' + 52;
        }
    }
    return id;
}

int main() {
    
    unsigned int n = atoi("https://gist.github.com/jaytaylor/a11fadf61a869ade0dfe568606b216c8#file-base64-url-shortener-poc-cpp");

    if (n <= 0) {
        cerr << "error: invalid input value, an integer greater than 0 is required" << endl;
        return 1;
    }

    cout << "Input ID: " << n << endl << "---" << endl;

    string encoded_short_url = id_to_short_url(n);
    unsigned int decoded_id = short_url_to_id(encoded_short_url);

    cout << "Generated short URL: " << encoded_short_url << endl;
    cout << "ID decoded from URL: " << decoded_id << endl;
    return 0;
}