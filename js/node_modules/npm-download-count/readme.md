npm-download-counts
===================

[![Build Status](https://secure.travis-ci.org/brillout/npm-download-counts.svg)](http://travis-ci.org/brillout/npm-download-counts)

*Note: the npm download counts are pretty dodgy for a number of reasons, you probably shouldn't pretend they are accurate.*

```js
const moment = require('moment')
    , downloadCounts = require('npm-download-count')

    , package_name    = 'levelup'
    , start  = moment().subtract(3, 'days').toDate() // start date for lookup
    , end    = new Date()                              // end date for lookup

downloadCounts({
    package_name,
    time_period: {
        start,
        end,
    },
})
.then(count => {
    console.log('%s was downloaded ~%d times in the last 3 days', package_name, count)
});

downloadCounts({
    package_name,
    time_period: 'last-month',
})
.then(count => {
    console.log('%s was downloaded ~%d times in the last month', package_name, count)
});
```

Gives you something like:

```
levelup was downloaded ~122450 times in the last month
levelup was downloaded ~16344 times in the last 3 days
```
