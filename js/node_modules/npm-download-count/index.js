const got = require('got');
const assert = require('assert');
const Promise = require('bluebird');
Promise.longStackTraces();


module.exports = ({package_name, time_period}) => {

    const time_period_str = (() => {
        if( time_period.constructor === String ) return time_period;
        return get_day(time_period.start) + ':' + get_day(time_period.end);
    })();

    const url = 'https://api.npmjs.org/downloads/point/' + time_period_str + '/' + package_name;

    return (
        Promise.resolve()
        .then(() =>
            got(url, {json: true})
        )
        .then(({body}) => {
            assert(body);
            assert(body.downloads >= 0 || body.error);

            if( body.downloads >= 0 ) {
                return body.downloads;
            }

            if( body.error ) {
                throw new Error(body.error);
            }

            assert(false);
        })
        .catch(error => {

            if( error.message ) {
                const msg = error.message;
                assert( msg.includes('0002') === msg.includes('no stats for this package for this period') );

                if( msg.includes('0002') ) {
                    return 0;
                }
            }

            throw error;
        })
        .then(downloads => {
            assert(downloads >= 0);

            return downloads;
        })
    );

};


function get_day (s) {
  if (!(s instanceof Date)) {
    if (!Date.parse(s))
      return null
    s = new Date(s)
  }
  return s.toISOString().substr(0, 10)
}
