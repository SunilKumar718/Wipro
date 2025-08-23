import { Component } from "react";
// Class Component
class MovieForm extends Component {
    constructor(props) {  //Initializes the component
        super(props);
        console.log("constructor executed");

        this.state = {        //initializes form input fields
            movieTitle: "",
            director: "",
            releaseYear: "",
            genre: "Action",  //default value
            rating: "",
            description: "",
            platforms: {           //checkboxes are boolean means key value pair,updating one chekcbox doesnt affect other and no traversal is needed just flipping
                netflix: false,
                prime: false,
                disney: false,  //initially all are not checked
                others: false,
            },
            movies: [],  //array to store the submitted movie inputs
        };
    }

    static getDerivedStateFromProps(props, state) { //runs before every render
        console.log("getDerivedStateFromProps executed");
        return null; //we dont need to update the state here
    };

    componentDidMount() { //runs once after the component is mounted into dom
        console.log("componentDidMount executed"); //component fully visible in UI
    }

    shouldComponentUpdate(nextProps, nextState) { //it decides if the component should re-render 
        console.log("shouldComponentUpdate executed");
        return true; //if true it is re-rendered
    }

    getSnapshotBeforeUpdate(prevProps, prevState) { //takes the photo of dom before updating
        console.log("getSnapshotBeforeUpdate executed");
        return null;
    }

    componentDidUpdate(prevProps, prevState, snapshot) { //runs after dom update is done
        console.log("componentDidUpdate executed");
    }

    componentWillUnmount() { //runs just before component is unmounted or cleared
        console.log("componentWillUnmount executed");
    }
    //change handler
    handleChange = (e) => {
        const { name, value, type, checked } = e.target; //destructuring

        if (type === "checkbox") {
            this.setState((prevState) => ({
                platforms: {
                    ...prevState.platforms,  //copies the old state of all platforms checkboxes
                    [name]: checked,    //updates the specific checkbox checked
                },
            }));
        } else {
            this.setState({ //handling for all other inputs
                [name]: value,
            });
        }
    };

    //form submission handler
    handleSubmit = (e) => {
        e.preventDefault(); //reloads page after submitting
        const newMovie = {  //storing the new movie data
            movieTitle: this.state.movieTitle,
            director: this.state.director,
            releaseYear: this.state.releaseYear,
            genre: this.state.genre,
            rating: this.state.rating,
            description: this.state.description,
            platforms: Object.entries(this.state.platforms) //converts it into [key, value] pairs
                .filter(([key, value]) => value) //filters like keeps only the values checked
                .map(([key]) => key), //extracts only the keys by dropping the boolean
        };

        this.setState((prevState) => ({
            movies: [...prevState.movies, newMovie], //spread operator for merging old data with new data
            movieTitle: "",
            director: "",
            releaseYear: "",
            genre: "Action",
            rating: "",          // resetting the form fields so that user can add new movie details
            description: "",
            platforms: {
                netflix: false,
                prime: false,
                disney: false,
                others: false,
            },
        }));
    }


    render() {
        console.log("render executed");

        return (
            <div className="container mt-4">
                <div className="card shadow">
                    <div className="card-header bg-primary text-white">
                        <h3>Add Movie</h3>
                    </div>
                    <div className="card-body text-start">
                        <form onSubmit={this.handleSubmit}>
                            {/* Movie Title */}
                            <div className="mb-3">
                                <label className="form-label">Movie Title</label>
                                <input
                                    type="text"
                                    name="movieTitle"
                                    className="form-control"
                                    value={this.state.movieTitle}
                                    onChange={this.handleChange} //triggers when changed
                                    required
                                />
                            </div>

                            {/* Director */}
                            <div className="mb-3">
                                <label className="form-label">Director</label>
                                <input
                                    type="text"
                                    name="director"
                                    className="form-control"
                                    value={this.state.director} //control component
                                    onChange={this.handleChange} //triggers when changed
                                    required
                                />
                            </div>

                            {/*Release Year*/}
                            <div className="mb-3">
                                <label className="form-label">Release Year</label>
                                <input
                                    type="number"
                                    name="releaseYear"
                                    className="form-control"
                                    value={this.state.releaseYear}
                                    onChange={this.handleChange}
                                    required
                                />
                            </div>

                            {/* Genre */}
                            <div className="mb-3">
                                <label className="form-label">Genre</label>
                                <select
                                    name="genre"
                                    className="form-select"
                                    value={this.state.genre}
                                    onChange={this.handleChange} //
                                >
                                    <option>Action</option>
                                    <option>Comedy</option>
                                    <option>Drama</option>
                                    <option>Sci-Fi</option>
                                    <option>Horror</option>
                                </select>
                            </div>


                            {/* Rating */}
                            <div className="mb-3">
                                <label className="form-label">Rating</label><br />

                                <input
                                    type="radio"
                                    name="rating"
                                    value="1"
                                    checked={this.state.rating === "1"}
                                    onChange={this.handleChange}
                                    className="form-check-input"
                                    required
                                />
                                <label className="form-check-label me-2">1</label>

                                <input
                                    type="radio"
                                    name="rating"
                                    value="2"
                                    checked={this.state.rating === "2"}
                                    onChange={this.handleChange}
                                    className="form-check-input"
                                    required
                                />
                                <label className="form-check-label me-2">2</label>

                                <input
                                    type="radio"
                                    name="rating"
                                    value="3"
                                    checked={this.state.rating === "3"}
                                    onChange={this.handleChange}
                                    className="form-check-input"
                                    required
                                />
                                <label className="form-check-label me-2">3</label>

                                <input
                                    type="radio"
                                    name="rating"
                                    value="4"
                                    checked={this.state.rating === "4"}
                                    onChange={this.handleChange}
                                    className="form-check-input"
                                    required
                                />
                                <label className="form-check-label me-2">4</label>

                                <input
                                    type="radio"
                                    name="rating"
                                    value="5"
                                    checked={this.state.rating === "5"}
                                    onChange={this.handleChange}
                                    className="form-check-input"
                                    required
                                />
                                <label className="form-check-label">5</label>
                            </div>


                            {/* Description */}
                            <div className="mb-3">
                                <label className="form-label">Description</label>
                                <textarea
                                    name="description"
                                    className="form-control"
                                    value={this.state.description}
                                    onChange={this.handleChange}
                                />
                            </div>

                            {/* Platforms */}
                            <div className="mb-3">
                                <label className="form-label">Available On</label>
                                <div className="form-check">
                                    <input
                                        type="checkbox"
                                        name="netflix"
                                        className="form-check-input"
                                        checked={this.state.platforms.netflix}
                                        onChange={this.handleChange}
                                    />
                                    <label className="form-check-label">Netflix</label>
                                </div>
                                <div className="form-check">
                                    <input
                                        type="checkbox"
                                        name="prime"
                                        className="form-check-input"
                                        checked={this.state.platforms.prime}
                                        onChange={this.handleChange}
                                    />
                                    <label className="form-check-label">Amazon Prime</label>
                                </div>
                                <div className="form-check">
                                    <input
                                        type="checkbox"
                                        name="disney"
                                        className="form-check-input"
                                        checked={this.state.platforms.disney}
                                        onChange={this.handleChange}
                                    />
                                    <label className="form-check-label">Disney+</label>
                                </div>

                                <div className="form-check">
                                    <input
                                        type="checkbox"
                                        name="others"
                                        className="form-check-input"
                                        checked={this.state.platforms.others}
                                        onChange={this.handleChange}
                                    />
                                    <label className="form-check-label">Others</label>
                                </div>
                            </div>

                            {/* Submit Button */}
                            <button type="submit" className="btn btn-success">
                                Add Movie
                            </button>
                        </form>
                    </div>
                </div>

                {/* Table to display movies */}
                <div className="mt-4">
                    <h4>Movie List</h4>
                    <table className="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Director</th>
                                <th>Year</th>
                                <th>Genre</th>
                                <th>Rating</th>
                                <th>Description</th>
                                <th>Platforms</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.movies.map((movie, index) => (
                                <tr key={index}>
                                    <td>{movie.movieTitle}</td>
                                    <td>{movie.director}</td>
                                    <td>{movie.releaseYear}</td>
                                    <td>{movie.genre}</td>
                                    <td>{movie.rating}</td>
                                    <td>{movie.description}</td>
                                    <td>{movie.platforms.join(", ")}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
                <hr/>
            </div>
        );
    }
}

export default MovieForm;