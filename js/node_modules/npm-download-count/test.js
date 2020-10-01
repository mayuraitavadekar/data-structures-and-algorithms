const assert = require('assert')
    , moment = require('moment')
    , downloadCounts = require('./')

    , package_name = 'levelup'
    , start  = moment().subtract(5, 'days').utcOffset(0).toDate()
    , end = moment().utcOffset(0).toDate();

downloadCounts({
    package_name,
    time_period: {
        start,
        end,
    },
})
.then(count => {
    assert(count >= 0);
})
.catch(err => assert(!err));

downloadCounts({
    package_name,
    time_period: 'last-month',
})
.then(count => {
    assert(count >= 0);
})
.catch(err => assert(!err));

downloadCounts({
    package_name: 'asdfasdfasdfasdfasdfa',
    time_period: {
        start,
        end,
    },
})
.then(() => assert(false))
.catch(err => {assert(err) && assert.equal(err.message, 'registry error: no stats for this package for this range (0008)')});
