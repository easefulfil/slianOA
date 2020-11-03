/*

 Licensed under the GPL license: http://www.gnu.org/licenses/gpl.txt
 
 */
var bootstrap = (function() {

    function getcookie(name) {
        var cookie_start = document.cookie.indexOf(name);
        var cookie_end = document.cookie.indexOf(";", cookie_start);
        return cookie_start == -1 ? '' : unescape(document.cookie.substring(cookie_start + name.length + 1, (cookie_end > cookie_start ? cookie_end : document.cookie.length)));
    }
    function setcookie(cookieName, cookieValue, seconds, path, domain, secure) {
        var expires = new Date();
        expires.setTime(expires.getTime() + seconds);
        document.cookie = escape(cookieName) + '=' + escape(cookieValue)
            + (expires ? '; expires=' + expires.toGMTString() : '')
            + (path ? '; path=' + path : '/')
            + (domain ? '; domain=' + domain : '')
            + (secure ? '; secure' : '');
    }

    var scripts = document.getElementsByTagName('script'),
    //是否是开发模式
        isDevelopment = false,defaultTheme = 'default',lang = 'zh_CN',suffix = '',
        path, i, ln, scriptSrc, match;

    var themeCookie = getcookie('theme');
    if(themeCookie){
        defaultTheme = themeCookie;
    }

    for (i = 0, ln = scripts.length; i < ln; i++) {
        scriptSrc = scripts[i].src;

        match = scriptSrc.match(/bootstrap\.js$/);

        if (match) {
            path = scriptSrc.substring(0, scriptSrc.length - match[0].length);
            break;
        }
    }

    if(!isDevelopment){
        suffix = '.min';
    }

    if(!isDevelopment){

        document.write('<script type="text/javascript" src="' + path + 'easyui/jquery.min.js"></script>');

        document.write('<link id="easyuiTheme" rel="stylesheet" type="text/css" href="' +
            path + 'easyui/themes/' + defaultTheme + '/easyui.css">');

        /*document.write('<script type="text/javascript" charset="UTF-8" src="' +
            path + 'easyui/easyui.all.min.js"></script>');*/
        
        document.write('<script type="text/javascript" charset="UTF-8" src="' +
                path + 'easyui/jquery.easyui.min.js"></script>');

        document.write('<script type="text/javascript" charset="UTF-8" src="' +
            path + 'easyui/locale/ui/lang-' + lang + '.min.js"></script>');

    }else{

        document.write('<script type="text/javascript" src="' + path + 'lib/jquery.min.js"></script>');

        document.write('<script type="text/javascript" charset="UTF-8" src="' +
            path + 'easyloader.js"></script>');
    }

    //document.write('<link rel="stylesheet" type="text/css" href="' + path + 'easyui/themes/icon'+ suffix + '.css">');
    document.write('<link rel="stylesheet" type="text/css" href="' + path + 'webpage/demo.css">');
    /*补充其他公共js、css*/
    document.write('<script type="text/javascript" charset="UTF-8" src="' + path + 'Exteasyui/datagrid-detailview.js"></script>');
    document.write('<script type="text/javascript" charset="UTF-8" src="' + path + 'Exteasyui/onCollapse.js"></script>');
    document.write('<script type="text/javascript" charset="UTF-8" src="' + path + 'Exteasyui/datetimebox.js"></script>');
    document.write('<script type="text/javascript" charset="UTF-8" src="' + path + 'js/fleetUtil/FleetUtil.js"></script>');
    document.write('<script type="text/javascript" charset="UTF-8" src="' + path + 'js/fullScreen.js"></script>');
    document.write('<link rel="stylesheet" type="text/css" href="' + path + 'css/icons/icon-all.css">');
    document.write('<link rel="stylesheet" type="text/css" href="' + path + 'css/icons/icon.css">');
    return {
        path : path,
        examplePath : path + 'demo/',
        defaultTheme : defaultTheme,
        setcookie : setcookie
    }
})();
