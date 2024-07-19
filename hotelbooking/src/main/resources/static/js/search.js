window.addEventListener('load', function () {
    const searchField = document.querySelector('#search');
    if (searchField) {
        const searchResults = document.querySelector('#search-results');
        searchField.addEventListener('keyup', function(event) {
            const searchTerm = event.target.value;
            if (searchTerm.length >= 2) {
                fetch(`/api/guests?searchTerm=${searchTerm}`)
                    .then(response => response.json())
                    .then(guests => {
                        let html = `<p>Found ${guests.length} results</p>`;
                        html += '<ul>';
                        guests.forEach(guest => {
                            html += `<li><a href="/guests/${guest.guestId}">${guest.guestLastName}</a></li>`;
                        });
                        html += '</ul>';
                        searchResults.innerHTML = html;
                    });
            } else {
                searchResults.innerHTML = ''; // clear search
            }
        });
    }
});
